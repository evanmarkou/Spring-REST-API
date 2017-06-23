package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SensorSweat;
import mdx.gsd.data.service.SensorSweatService;
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
@RequestMapping(value = "/project/sensor/sweat")
@Api(value = "sensorSweat", description = "Operations pertaining to sensor sweat projects in GSD")
public class SensorSweatController {

    private Logger logger;

    private final SensorSweatService sensorSweatService;

    private final UserService userService;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    public SensorSweatController(UserService userService, SensorSweatService sensorSweatService) {
        this.userService = userService;
        this.sensorSweatService = sensorSweatService;
    }

    @ApiOperation(value = "View a list of available sensor sweat projects", response = SensorSweat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<?> getAllSweat() {
        List<SensorSweat> sensorSweatList = this.sensorSweatService.getAllSensorSweat();
        if (sensorSweatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorSweatList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available sensor sweat projects", response = SensorSweat.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<?> getUserSweat(@PathVariable("id") String id) {
        List<SensorSweat> sensorSweatList = this.sensorSweatService.getUserSensorSweat(id);
        if (sensorSweatList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorSweatList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a sensor sweat project with an ID", response = SensorSweat.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorSweat> getSpecificSweat(@PathVariable("id") Integer id) {
        logger.info("Fetching SensorSweat with id " + id);
        SensorSweat sensorSweat = this.sensorSweatService.getSensorSweatById(id);
        if (sensorSweat == null) {
            logger.info("SensorSweat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorSweat, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a sensor sweat project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addSweat(@PathVariable("id") String id, @Valid @RequestBody SensorSweat sensorSweat, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Sensor Sweat Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        sensorSweat.setSensorSweatUser(this.userService.getUserById(id));
        this.sensorSweatService.addSensorSweat(sensorSweat);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/sensor/sweat/{id}").buildAndExpand(sensorSweat.getSensorSweatId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a sensor sweat project")
    @PutMapping("/{id:\\d+}/update")
    public ResponseEntity<SensorSweat> updateSweat(@PathVariable("id") Integer id, @Valid @RequestBody SensorSweat sensorSweat) {
        logger.info("Updating SensorSweat " + id);
        SensorSweat currentSensorSweat = this.sensorSweatService.getSensorSweatById(id);
        if (currentSensorSweat == null) {
            logger.info("SensorSweat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (sensorSweat.getSweatlevel() != null)
            currentSensorSweat.setSweatlevel(sensorSweat.getSweatlevel());

        this.sensorSweatService.updateSensorSweat(currentSensorSweat);
        return new ResponseEntity<>(currentSensorSweat, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a sensor sweat project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SensorSweat> deleteSweat(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SensorSweat with id " + id);

        SensorSweat sensorSweat = this.sensorSweatService.getSensorSweatById(id);
        if (sensorSweat == null) {
            logger.info("Unable to delete. SensorSweat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.sensorSweatService.removeSensorSweat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
