package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SensorAudio;
import mdx.gsd.data.service.SensorAudioService;
import mdx.gsd.data.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by universe (E.) on 16/06/17.
 */

@RestController
@RequestMapping(value = "/project/sensor/audio")
@Api(value = "sensorAudio", description = "Operations pertaining to sensor audio projects in GSD")
public class SensorAudioController {

    private Logger logger;

    private final SensorAudioService sensorAudioService;

    private final UserService userService;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    public SensorAudioController(SensorAudioService sensorAudioService, UserService userService) {
        this.sensorAudioService = sensorAudioService;
        this.userService = userService;
    }

    @ApiOperation(value = "View a list of available sensor audio projects", response = SensorAudio.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<?> getAllAudio() {
        List<SensorAudio> sensorAudioList = this.sensorAudioService.getAllSensorAudio();
        if (sensorAudioList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorAudioList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available sensor audio projects", response = SensorAudio.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SensorAudio>> getUserAudio(@PathVariable("id") String id) {
        List<SensorAudio> sensorAudioList = this.sensorAudioService.getUserSensorAudio(id);
        if (sensorAudioList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sensorAudioList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a sensor audio project with an ID", response = SensorAudio.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorAudio> getSpecificAudio(@PathVariable("id") Integer id) {
        logger.info("Fetching SensorAudio with id " + id);
        SensorAudio sensorAudio = this.sensorAudioService.getSensorAudioById(id);
        if (sensorAudio == null) {
            logger.info("SensorAudio with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorAudio, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a sensor audio project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addAudio(@PathVariable("id") String id, @RequestBody SensorAudio sensorAudio, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Sensor Audio Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        sensorAudio.setSensorAudioUser(this.userService.getUserById(id));
        this.sensorAudioService.addSensorAudio(sensorAudio);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/sensor/audio/{id}").buildAndExpand(sensorAudio.getSensorAudioId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a sensor audio project")
    @PutMapping("/{id:\\d+}/update")
    public ResponseEntity<SensorAudio> updateAudio(@PathVariable("id") Integer id, @RequestBody SensorAudio sensorAudio) {
        logger.info("Updating SensorAudio " + id);
        SensorAudio currentSensorAudio = this.sensorAudioService.getSensorAudioById(id);
        if (currentSensorAudio == null) {
            logger.info("SensorAudio with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (sensorAudio.getAngle() != null)
            currentSensorAudio.setAngle(sensorAudio.getAngle());
        if (sensorAudio.getEnergy() != null)
            currentSensorAudio.setEnergy(sensorAudio.getEnergy());
        if ((sensorAudio.getConfidence() != null))
            currentSensorAudio.setConfidence(sensorAudio.getConfidence());

        this.sensorAudioService.updateSensorAudio(currentSensorAudio);
        return new ResponseEntity<>(currentSensorAudio, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a sensor audio project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SensorAudio> deleteAudio(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SensorAudio with id " + id);

        SensorAudio sensorAudio = this.sensorAudioService.getSensorAudioById(id);
        if (sensorAudio == null) {
            logger.info("Unable to delete. SensorAudio with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.sensorAudioService.removeSensorAudio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
