package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SurveyVak;
import mdx.gsd.data.service.SurveyVakService;
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
@RequestMapping(value = "/project/survey/vak")
@Api(value = "surveyVak", description = "Operations pertaining to survey vak projects in GSD")
public class SurveyVakController {

    private Logger logger;

    private final SurveyVakService surveyVakService;

    private final UserService userService;

    @Autowired
    public SurveyVakController(UserService userService, SurveyVakService surveyVakService) {
        this.userService = userService;
        this.surveyVakService = surveyVakService;
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @ApiOperation(value = "View a list of available survey vak projects", response = SurveyVak.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SurveyVak>> getAllVak() {
        List<SurveyVak> surveyVakList = this.surveyVakService.getAllSurveyVak();
        if (surveyVakList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyVakList, HttpStatus.OK);
    }

    @ApiOperation(value = "View a list of each user's available survey vak projects", response = SurveyVak.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SurveyVak>> getUserVak(@PathVariable("id") String id) {
        List<SurveyVak> surveyVakList = this.surveyVakService.getUserSurveyVak(id);
        if (surveyVakList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyVakList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a survey vak project with an ID", response = SurveyVak.class)
    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyVak> getSpecificVak(@PathVariable("id") Integer id) {
        logger.info("Fetching SurveyVak with id " + id);
        SurveyVak surveyVak = this.surveyVakService.getSurveyVakById(id);
        if (surveyVak == null) {
            logger.info("SurveyVak with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(surveyVak, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a survey vak project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addVak(@PathVariable("id") String id, @Valid @RequestBody SurveyVak surveyVak, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Survey Vak Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        surveyVak.setSurveyVakUser(this.userService.getUserById(id));
        this.surveyVakService.addSurveyVak(surveyVak);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/survey/paei/{id}").buildAndExpand(surveyVak.getSurveyVakId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a survey vak project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SurveyVak> deleteVak(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SurveyVak with id " + id);

        SurveyVak surveyVak = this.surveyVakService.getSurveyVakById(id);
        if (surveyVak == null) {
            logger.info("Unable to delete. SurveyVak with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.surveyVakService.removeSurveyVak(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
