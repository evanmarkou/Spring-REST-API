package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SensorEmotion;
import mdx.gsd.data.service.SensorEmotionService;
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

import javax.validation.Valid;
import java.util.List;


/**
 * Created by universe (E.) on 18/06/17.
 */

@RestController
@RequestMapping(value = "/project/sensor/emotion", produces = "application/json")
@Api(value = "sensorEmotion", description = "Operations pertaining to sensor emotion projects in GSD")
public class SensorEmotionController {

    private Logger logger;

    private final SensorEmotionService sensorEmotionService;

    private final UserService userService;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    public SensorEmotionController(UserService userService, SensorEmotionService sensorEmotionService) {
        this.userService = userService;
        this.sensorEmotionService = sensorEmotionService;
    }

    @ApiOperation(value = "View a list of available sensor emotion projects", response = SensorEmotion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SensorEmotion>> getAllEmotion() {
        List<SensorEmotion> sensorEmotionList = this.sensorEmotionService.getAllSensorEmotion();
        if (sensorEmotionList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sensorEmotionList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available sensor emotion projects", response = SensorEmotion.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SensorEmotion>> getUserEmotion(@PathVariable("id") String id) {
        List<SensorEmotion> sensorEmotionList = this.sensorEmotionService.getUserSensorEmotion(id);
        if (sensorEmotionList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sensorEmotionList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a sensor emotion project with an ID", response = SensorEmotion.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorEmotion> getSpecificEmotion(@PathVariable("id") Integer id) {
        logger.info("Fetching SensorEmotion with id " + id);
        SensorEmotion sensorEmotion = this.sensorEmotionService.getSensorEmotionById(id);
        if (sensorEmotion == null) {
            logger.info("SensorEmotion with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorEmotion, HttpStatus.OK);
    }


    @ApiOperation(value = "Add a sensor emotion project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addEmotion(@PathVariable("id") String id, @Valid @RequestBody SensorEmotion sensorEmotion, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Sensor Emotion Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        sensorEmotion.setSensorEmotionUser(this.userService.getUserById(id));
        this.sensorEmotionService.addSensorEmotion(sensorEmotion);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/sensor/emotion/{id}").buildAndExpand(sensorEmotion.getSensorEmotionId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a sensor emotion project")
    @PutMapping("/{id:\\d+}/update")
    public ResponseEntity<SensorEmotion> updateEmotion(@PathVariable("id") Integer id, @Valid @RequestBody SensorEmotion sensorEmotion) {
        logger.info("Updating SensorEmotion " + id);
        SensorEmotion currentSensorEmotion = this.sensorEmotionService.getSensorEmotionById(id);
        if (currentSensorEmotion == null) {
            logger.info("SensorEmotion with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (sensorEmotion.getDominantEmotion() != null)
            currentSensorEmotion.setDominantEmotion(sensorEmotion.getDominantEmotion());
        if (sensorEmotion.getScore() != null)
            currentSensorEmotion.setScore(sensorEmotion.getScore());

        this.sensorEmotionService.updateSensorEmotion(currentSensorEmotion);
        return new ResponseEntity<>(currentSensorEmotion, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a sensor emotion project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SensorEmotion> deleteEmotion(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SensorEmotion with id " + id);

        SensorEmotion sensorEmotion = this.sensorEmotionService.getSensorEmotionById(id);
        if (sensorEmotion == null) {
            logger.info("Unable to delete. SensorEmotion with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.sensorEmotionService.removeSensorEmotion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
