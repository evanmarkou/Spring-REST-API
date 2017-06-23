package mdx.gsd.data.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Entity
@Table(name = "SurveyBelbin")
public class SurveyBelbin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Survey Belbin ID")
    private Integer surveyBelbinId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User surveyBelbinUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SurveyBelbin data insertion")
    private LocalDateTime submissionTime;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q1h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q2h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q3h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q4h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q5h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q6h;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7a;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7b;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7c;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7d;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7e;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7f;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7g;

    @NotNull
    @Min(0)
    @Max(10)
    @ApiModelProperty(notes = "Field to fill in the survey question")
    @Column(nullable = false)
    private Short q7h;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short implementer;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short coordinator;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short shaper;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short plant;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short resourceinvestigator;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short monitorevaluator;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short teamworker;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short completefinisher;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Type of person coming from the results of survey")
    @Column(nullable = false)
    private Short specialist;

    public SurveyBelbin(User surveyBelbinUser, Integer surveyBelbinId, LocalDateTime submissionTime, Short q1a,
                        Short q1b, Short q1c, Short q1d, Short q1e, Short q1f, Short q1g, Short q1h,
                        Short q2a, Short q2b, Short q2c, Short q2d, Short q2e, Short q2f, Short q2g,
                        Short q2h, Short q3a, Short q3b, Short q3c, Short q3d, Short q3e, Short q3f,
                        Short q3g, Short q3h, Short q4a, Short q4b, Short q4c, Short q4d, Short q4e,
                        Short q4f, Short q4g, Short q4h, Short q5a, Short q5b, Short q5c, Short q5d,
                        Short q5e, Short q5f, Short q5g, Short q5h, Short q6a, Short q6b, Short q6c,
                        Short q6d, Short q6e, Short q6f, Short q6g, Short q6h, Short q7a, Short q7b,
                        Short q7c, Short q7d, Short q7e, Short q7f, Short q7g, Short q7h,
                        Short implementer, Short coordinator, Short shaper, Short plant,
                        Short resourceinvestigator, Short monitorevaluator, Short teamworker,
                        Short completefinisher, Short specialist) {
        this.surveyBelbinUser = surveyBelbinUser;
        this.surveyBelbinId = surveyBelbinId;
        this.submissionTime = submissionTime;
        this.q1a = q1a;
        this.q1b = q1b;
        this.q1c = q1c;
        this.q1d = q1d;
        this.q1e = q1e;
        this.q1f = q1f;
        this.q1g = q1g;
        this.q1h = q1h;
        this.q2a = q2a;
        this.q2b = q2b;
        this.q2c = q2c;
        this.q2d = q2d;
        this.q2e = q2e;
        this.q2f = q2f;
        this.q2g = q2g;
        this.q2h = q2h;
        this.q3a = q3a;
        this.q3b = q3b;
        this.q3c = q3c;
        this.q3d = q3d;
        this.q3e = q3e;
        this.q3f = q3f;
        this.q3g = q3g;
        this.q3h = q3h;
        this.q4a = q4a;
        this.q4b = q4b;
        this.q4c = q4c;
        this.q4d = q4d;
        this.q4e = q4e;
        this.q4f = q4f;
        this.q4g = q4g;
        this.q4h = q4h;
        this.q5a = q5a;
        this.q5b = q5b;
        this.q5c = q5c;
        this.q5d = q5d;
        this.q5e = q5e;
        this.q5f = q5f;
        this.q5g = q5g;
        this.q5h = q5h;
        this.q6a = q6a;
        this.q6b = q6b;
        this.q6c = q6c;
        this.q6d = q6d;
        this.q6e = q6e;
        this.q6f = q6f;
        this.q6g = q6g;
        this.q6h = q6h;
        this.q7a = q7a;
        this.q7b = q7b;
        this.q7c = q7c;
        this.q7d = q7d;
        this.q7e = q7e;
        this.q7f = q7f;
        this.q7g = q7g;
        this.q7h = q7h;
        this.implementer = implementer;
        this.coordinator = coordinator;
        this.shaper = shaper;
        this.plant = plant;
        this.resourceinvestigator = resourceinvestigator;
        this.monitorevaluator = monitorevaluator;
        this.teamworker = teamworker;
        this.completefinisher = completefinisher;
        this.specialist = specialist;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SurveyBelbin() {
    }

    public User getSurveyBelbinUser() {
        return surveyBelbinUser;
    }

    public void setSurveyBelbinUser(User surveyBelbinUser) {
        this.surveyBelbinUser = surveyBelbinUser;
    }

    public Integer getSurveyBelbinId() {
        return surveyBelbinId;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public Short getQ1a() {
        return q1a;
    }

    public void setQ1a(Short q1a) {
        this.q1a = q1a;
    }

    public Short getQ1b() {
        return q1b;
    }

    public void setQ1b(Short q1b) {
        this.q1b = q1b;
    }

    public Short getQ1c() {
        return q1c;
    }

    public void setQ1c(Short q1c) {
        this.q1c = q1c;
    }

    public Short getQ1d() {
        return q1d;
    }

    public void setQ1d(Short q1d) {
        this.q1d = q1d;
    }

    public Short getQ1e() {
        return q1e;
    }

    public void setQ1e(Short q1e) {
        this.q1e = q1e;
    }

    public Short getQ1f() {
        return q1f;
    }

    public void setQ1f(Short q1f) {
        this.q1f = q1f;
    }

    public Short getQ1g() {
        return q1g;
    }

    public void setQ1g(Short q1g) {
        this.q1g = q1g;
    }

    public Short getQ1h() {
        return q1h;
    }

    public void setQ1h(Short q1h) {
        this.q1h = q1h;
    }

    public Short getQ2a() {
        return q2a;
    }

    public void setQ2a(Short q2a) {
        this.q2a = q2a;
    }

    public Short getQ2b() {
        return q2b;
    }

    public void setQ2b(Short q2b) {
        this.q2b = q2b;
    }

    public Short getQ2c() {
        return q2c;
    }

    public void setQ2c(Short q2c) {
        this.q2c = q2c;
    }

    public Short getQ2d() {
        return q2d;
    }

    public void setQ2d(Short q2d) {
        this.q2d = q2d;
    }

    public Short getQ2e() {
        return q2e;
    }

    public void setQ2e(Short q2e) {
        this.q2e = q2e;
    }

    public Short getQ2f() {
        return q2f;
    }

    public void setQ2f(Short q2f) {
        this.q2f = q2f;
    }

    public Short getQ2g() {
        return q2g;
    }

    public void setQ2g(Short q2g) {
        this.q2g = q2g;
    }

    public Short getQ2h() {
        return q2h;
    }

    public void setQ2h(Short q2h) {
        this.q2h = q2h;
    }

    public Short getQ3a() {
        return q3a;
    }

    public void setQ3a(Short q3a) {
        this.q3a = q3a;
    }

    public Short getQ3b() {
        return q3b;
    }

    public void setQ3b(Short q3b) {
        this.q3b = q3b;
    }

    public Short getQ3c() {
        return q3c;
    }

    public void setQ3c(Short q3c) {
        this.q3c = q3c;
    }

    public Short getQ3d() {
        return q3d;
    }

    public void setQ3d(Short q3d) {
        this.q3d = q3d;
    }

    public Short getQ3e() {
        return q3e;
    }

    public void setQ3e(Short q3e) {
        this.q3e = q3e;
    }

    public Short getQ3f() {
        return q3f;
    }

    public void setQ3f(Short q3f) {
        this.q3f = q3f;
    }

    public Short getQ3g() {
        return q3g;
    }

    public void setQ3g(Short q3g) {
        this.q3g = q3g;
    }

    public Short getQ3h() {
        return q3h;
    }

    public void setQ3h(Short q3h) {
        this.q3h = q3h;
    }

    public Short getQ4a() {
        return q4a;
    }

    public void setQ4a(Short q4a) {
        this.q4a = q4a;
    }

    public Short getQ4b() {
        return q4b;
    }

    public void setQ4b(Short q4b) {
        this.q4b = q4b;
    }

    public Short getQ4c() {
        return q4c;
    }

    public void setQ4c(Short q4c) {
        this.q4c = q4c;
    }

    public Short getQ4d() {
        return q4d;
    }

    public void setQ4d(Short q4d) {
        this.q4d = q4d;
    }

    public Short getQ4e() {
        return q4e;
    }

    public void setQ4e(Short q4e) {
        this.q4e = q4e;
    }

    public Short getQ4f() {
        return q4f;
    }

    public void setQ4f(Short q4f) {
        this.q4f = q4f;
    }

    public Short getQ4g() {
        return q4g;
    }

    public void setQ4g(Short q4g) {
        this.q4g = q4g;
    }

    public Short getQ4h() {
        return q4h;
    }

    public void setQ4h(Short q4h) {
        this.q4h = q4h;
    }

    public Short getQ5a() {
        return q5a;
    }

    public void setQ5a(Short q5a) {
        this.q5a = q5a;
    }

    public Short getQ5b() {
        return q5b;
    }

    public void setQ5b(Short q5b) {
        this.q5b = q5b;
    }

    public Short getQ5c() {
        return q5c;
    }

    public void setQ5c(Short q5c) {
        this.q5c = q5c;
    }

    public Short getQ5d() {
        return q5d;
    }

    public void setQ5d(Short q5d) {
        this.q5d = q5d;
    }

    public Short getQ5e() {
        return q5e;
    }

    public void setQ5e(Short q5e) {
        this.q5e = q5e;
    }

    public Short getQ5f() {
        return q5f;
    }

    public void setQ5f(Short q5f) {
        this.q5f = q5f;
    }

    public Short getQ5g() {
        return q5g;
    }

    public void setQ5g(Short q5g) {
        this.q5g = q5g;
    }

    public Short getQ5h() {
        return q5h;
    }

    public void setQ5h(Short q5h) {
        this.q5h = q5h;
    }

    public Short getQ6a() {
        return q6a;
    }

    public void setQ6a(Short q6a) {
        this.q6a = q6a;
    }

    public Short getQ6b() {
        return q6b;
    }

    public void setQ6b(Short q6b) {
        this.q6b = q6b;
    }

    public Short getQ6c() {
        return q6c;
    }

    public void setQ6c(Short q6c) {
        this.q6c = q6c;
    }

    public Short getQ6d() {
        return q6d;
    }

    public void setQ6d(Short q6d) {
        this.q6d = q6d;
    }

    public Short getQ6e() {
        return q6e;
    }

    public void setQ6e(Short q6e) {
        this.q6e = q6e;
    }

    public Short getQ6f() {
        return q6f;
    }

    public void setQ6f(Short q6f) {
        this.q6f = q6f;
    }

    public Short getQ6g() {
        return q6g;
    }

    public void setQ6g(Short q6g) {
        this.q6g = q6g;
    }

    public Short getQ6h() {
        return q6h;
    }

    public void setQ6h(Short q6h) {
        this.q6h = q6h;
    }

    public Short getQ7a() {
        return q7a;
    }

    public void setQ7a(Short q7a) {
        this.q7a = q7a;
    }

    public Short getQ7b() {
        return q7b;
    }

    public void setQ7b(Short q7b) {
        this.q7b = q7b;
    }

    public Short getQ7c() {
        return q7c;
    }

    public void setQ7c(Short q7c) {
        this.q7c = q7c;
    }

    public Short getQ7d() {
        return q7d;
    }

    public void setQ7d(Short q7d) {
        this.q7d = q7d;
    }

    public Short getQ7e() {
        return q7e;
    }

    public void setQ7e(Short q7e) {
        this.q7e = q7e;
    }

    public Short getQ7f() {
        return q7f;
    }

    public void setQ7f(Short q7f) {
        this.q7f = q7f;
    }

    public Short getQ7g() {
        return q7g;
    }

    public void setQ7g(Short q7g) {
        this.q7g = q7g;
    }

    public Short getQ7h() {
        return q7h;
    }

    public void setQ7h(Short q7h) {
        this.q7h = q7h;
    }

    public Short getImplementer() {
        return implementer;
    }

    public void setImplementer(Short implementer) {
        this.implementer = implementer;
    }

    public Short getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Short coordinator) {
        this.coordinator = coordinator;
    }

    public Short getShaper() {
        return shaper;
    }

    public void setShaper(Short shaper) {
        this.shaper = shaper;
    }

    public Short getPlant() {
        return plant;
    }

    public void setPlant(Short plant) {
        this.plant = plant;
    }

    public Short getResourceinvestigator() {
        return resourceinvestigator;
    }

    public void setResourceinvestigator(Short resourceinvestigator) {
        this.resourceinvestigator = resourceinvestigator;
    }

    public Short getMonitorevaluator() {
        return monitorevaluator;
    }

    public void setMonitorevaluator(Short monitorevaluator) {
        this.monitorevaluator = monitorevaluator;
    }

    public Short getTeamworker() {
        return teamworker;
    }

    public void setTeamworker(Short teamworker) {
        this.teamworker = teamworker;
    }

    public Short getCompletefinisher() {
        return completefinisher;
    }

    public void setCompletefinisher(Short completefinisher) {
        this.completefinisher = completefinisher;
    }

    public Short getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Short specialist) {
        this.specialist = specialist;
    }
}
