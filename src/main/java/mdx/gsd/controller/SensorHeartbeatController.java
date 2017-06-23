package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SensorHeartbeat;
import mdx.gsd.data.service.SensorHeartbeatService;
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
@RequestMapping(value = "/project/sensor/heartbeat")
@Api(value = "sensorHeartbeat", description = "Operations pertaining to sensor heartbeat projects in GSD")
public class SensorHeartbeatController {

    private Logger logger;

    private final SensorHeartbeatService sensorHeartbeatService;

    private final UserService userService;

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Autowired
    public SensorHeartbeatController(UserService userService, SensorHeartbeatService sensorHeartbeatService) {
        this.userService = userService;
        this.sensorHeartbeatService = sensorHeartbeatService;
    }

    @ApiOperation(value = "View a list of available sensor heartbeat projects", response = SensorHeartbeat.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SensorHeartbeat>> getAllHeartbeat() {
        List<SensorHeartbeat> sensorHeartbeatList = this.sensorHeartbeatService.getAllSensorHeartbeat();
        if (sensorHeartbeatList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sensorHeartbeatList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available sensor heartbeat projects", response = SensorHeartbeat.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SensorHeartbeat>> getUserHeartbeat(@PathVariable("id") String id) {
        List<SensorHeartbeat> sensorHeartbeatList = this.sensorHeartbeatService.getUserSensorHeartbeat(id);
        if (sensorHeartbeatList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(sensorHeartbeatList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a sensor heartbeat project with an ID", response = SensorHeartbeat.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SensorHeartbeat> getSpecificHeartbeat(@PathVariable("id") Integer id) {
        logger.info("Fetching SensorHeartbeat with id " + id);
        SensorHeartbeat sensorHeartbeat = this.sensorHeartbeatService.getSensorHeartbeatById(id);
        if (sensorHeartbeat == null) {
            logger.info("SensorHeartbeat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorHeartbeat, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a sensor heartbeat project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addHeartbeat(@PathVariable("id") String id, @Valid @RequestBody SensorHeartbeat sensorHeartbeat, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Sensor Heartbeat Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        sensorHeartbeat.setSensorHeartbeatUser(this.userService.getUserById(id));
        this.sensorHeartbeatService.addSensorHeartbeat(sensorHeartbeat);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/sensor/heartbeat/{id}").buildAndExpand(sensorHeartbeat.getSensorHeartbeatId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a sensor heartbeat project")
    @PutMapping("/{id:\\d+}/update")
    public ResponseEntity<SensorHeartbeat> updateHeartbeat(@PathVariable("id") Integer id, @Valid @RequestBody SensorHeartbeat sensorHeartbeat) {
        logger.info("Updating SensorHeartbeat " + id);
        SensorHeartbeat currentSensorHeartbeat = this.sensorHeartbeatService.getSensorHeartbeatById(id);
        if (currentSensorHeartbeat == null) {
            logger.info("SensorHeartbeat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (sensorHeartbeat.getRate() != null)
            currentSensorHeartbeat.setRate(sensorHeartbeat.getRate());

        this.sensorHeartbeatService.updateSensorHeartbeat(currentSensorHeartbeat);
        return new ResponseEntity<>(currentSensorHeartbeat, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a sensor heartbeat project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SensorHeartbeat> deleteHeartbeat(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SensorHeartbeat with id " + id);

        SensorHeartbeat sensorHeartbeat = this.sensorHeartbeatService.getSensorHeartbeatById(id);
        if (sensorHeartbeat == null) {
            logger.info("Unable to delete. SensorHeartbeat with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.sensorHeartbeatService.removeSensorHeartbeat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
