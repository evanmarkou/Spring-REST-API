package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SurveyPaei;
import mdx.gsd.data.service.SurveyPaeiService;
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
@RequestMapping(value = "/project/survey/paei")
@Api(value = "surveyPaei", description = "Operations pertaining to survey paei projects in GSD")
public class SurveyPaeiController {

    private Logger logger;

    private final SurveyPaeiService surveyPaeiService;

    private final UserService userService;

    @Autowired
    public SurveyPaeiController(UserService userService, SurveyPaeiService surveyPaeiService) {
        this.userService = userService;
        this.surveyPaeiService = surveyPaeiService;
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @ApiOperation(value = "View a list of available survey paei projects", response = SurveyPaei.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SurveyPaei>> getAllPaei() {
        List<SurveyPaei> surveyPaeiList = this.surveyPaeiService.getAllSurveyPaei();
        if (surveyPaeiList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyPaeiList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available survey paei projects", response = SurveyPaei.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SurveyPaei>> getUserPaei(@PathVariable("id") String id) {
        List<SurveyPaei> surveyPaeiList = this.surveyPaeiService.getUserSurveyPaei(id);
        if (surveyPaeiList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyPaeiList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a survey paei project with an ID", response = SurveyPaei.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyPaei> getSpecificPaei(@PathVariable("id") Integer id) {
        logger.info("Fetching SurveyPaei with id " + id);
        SurveyPaei surveyPaei = this.surveyPaeiService.getSurveyPaeiById(id);
        if (surveyPaei == null) {
            logger.info("SurveyPaei with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(surveyPaei, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a survey paei project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addPaei(@PathVariable("id") String id, @Valid @RequestBody SurveyPaei surveyPaei, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Survey Paei Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        surveyPaei.setSurveyPaeiUser(this.userService.getUserById(id));
        this.surveyPaeiService.addSurveyPaei(surveyPaei);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/survey/paei/{id}").buildAndExpand(surveyPaei.getSurveyPaeiId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a survey paei project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SurveyPaei> deletePaei(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SurveyPaei with id " + id);

        SurveyPaei surveyPaei = this.surveyPaeiService.getSurveyPaeiById(id);
        if (surveyPaei == null) {
            logger.info("Unable to delete. SurveyPaei with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.surveyPaeiService.removeSurveyPaei(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
