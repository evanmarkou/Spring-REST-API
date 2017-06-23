package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SurveyBelbin;
import mdx.gsd.data.service.SurveyBelbinService;
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
 * Created by universe (E.) on 16/06/17.
 */

@RestController
@RequestMapping(value = "/project/survey/belbin")
@Api(value = "surveyBelbin", description = "Operations pertaining to survey belbin projects in GSD")
public class SurveyBelbinController {

    private Logger logger;

    private final SurveyBelbinService surveyBelbinService;

    private final UserService userService;

    @Autowired
    public SurveyBelbinController(UserService userService, SurveyBelbinService surveyBelbinService) {
        this.userService = userService;
        this.surveyBelbinService = surveyBelbinService;
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @ApiOperation(value = "View a list of available survey belbin projects", response = SurveyBelbin.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SurveyBelbin>> getAllBelbin() {
        List<SurveyBelbin> surveyBelbinList = this.surveyBelbinService.getAllSurveyBelbin();
        if (surveyBelbinList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyBelbinList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available survey belbin projects", response = SurveyBelbin.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SurveyBelbin>> getUserBelbin(@PathVariable("id") String id) {
        List<SurveyBelbin> surveyBelbinList = this.surveyBelbinService.getUserSurveyBelbin(id);
        if (surveyBelbinList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyBelbinList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a survey belbin project with an ID", response = SurveyBelbin.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyBelbin> getSpecificBelbin(@PathVariable("id") Integer id) {
        logger.info("Fetching SurveyBelbin with id " + id);
        SurveyBelbin surveyBelbin = this.surveyBelbinService.getSurveyBelbinById(id);
        if (surveyBelbin == null) {
            logger.info("SurveyBelbin with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(surveyBelbin, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a survey belbin project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addBelbin(@PathVariable("id") String id, @Valid @RequestBody SurveyBelbin surveyBelbin, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Survey Belbin Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        surveyBelbin.setSurveyBelbinUser(this.userService.getUserById(id));
        this.surveyBelbinService.addSurveyBelbin(surveyBelbin);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/survey/belbin/{id}").buildAndExpand(surveyBelbin.getSurveyBelbinId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a survey belbin project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SurveyBelbin> deleteBelbin(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SurveyBelbin with id " + id);

        SurveyBelbin surveyBelbin = this.surveyBelbinService.getSurveyBelbinById(id);
        if (surveyBelbin == null) {
            logger.info("Unable to delete. SurveyBelbin with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.surveyBelbinService.removeSurveyBelbin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
