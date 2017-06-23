package mdx.gsd.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mdx.gsd.data.model.SurveyMbti;
import mdx.gsd.data.service.SurveyMbtiService;
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
@RequestMapping(value = "/project/survey/mbti")
@Api(value = "surveyMbti", description = "Operations pertaining to survey mbti projects in GSD")
public class SurveyMbtiController {

    private Logger logger;

    private final SurveyMbtiService surveyMbtiService;

    private final UserService userService;

    @Autowired
    public SurveyMbtiController(SurveyMbtiService surveyMbtiService, UserService userService) {
        this.surveyMbtiService = surveyMbtiService;
        this.userService = userService;
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @ApiOperation(value = "View a list of available survey mbti projects", response = SurveyMbti.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/list")
    public ResponseEntity<List<SurveyMbti>> getAllMbti() {
        List<SurveyMbti> surveyMbtiList = this.surveyMbtiService.getAllSurveyMbti();
        if (surveyMbtiList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyMbtiList, HttpStatus.OK);
    }

    @ApiOperation(value = "Search a survey mbti project with an ID", response = SurveyMbti.class)
    @GetMapping("/user/{id}/list")
    public ResponseEntity<List<SurveyMbti>> getUserMbti(@PathVariable("id") String id) {
        List<SurveyMbti> surveyMbtiList = this.surveyMbtiService.getUserSurveyMbti(id);
        if (surveyMbtiList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(surveyMbtiList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SurveyMbti> getSpecificMbti(@PathVariable("id") Integer id) {
        logger.info("Fetching SurveyMbti with id " + id);
        SurveyMbti surveyMbti = this.surveyMbtiService.getSurveyMbtiById(id);
        if (surveyMbti == null) {
            logger.info("SurveyMbti with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(surveyMbti, HttpStatus.OK);
    }

    @ApiOperation(value = "Add a survey mbti project for a specific user")
    @PostMapping("/user/{id}/add")
    public ResponseEntity<?> addMbti(@PathVariable("id") String id, @Valid @RequestBody SurveyMbti surveyMbti, UriComponentsBuilder builder) {
        if (this.userService.getUserById(id) == null) {
            FieldError error = new FieldError("Survey Mbti Project", "User ID: " + id, id, false, null, null, "There no such user. Check Request Parameter again");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        surveyMbti.setSurveyMbtiUser(this.userService.getUserById(id));
        this.surveyMbtiService.addSurveyMbti(surveyMbti);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/project/survey/mbti/{id}").buildAndExpand(surveyMbti.getSurveyMbtiId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete a survey mbti project")
    @DeleteMapping("/{id:\\d+}/delete")
    public ResponseEntity<SurveyMbti> deleteMbti(@PathVariable("id") Integer id) {
        logger.info("Fetching & Deleting SurveyMbti with id " + id);

        SurveyMbti surveyMbti = this.surveyMbtiService.getSurveyMbtiById(id);
        if (surveyMbti == null) {
            logger.info("Unable to delete. SurveyMbti with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.surveyMbtiService.removeSurveyMbti(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
