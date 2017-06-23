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
@Table(name = "SurveyVak")
public class SurveyVak implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Survey Vak ID")
    private Integer surveyVakId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User surveyVakUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SurveyVak data insertion")
    private LocalDateTime submissionTime;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q1;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q2;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q3;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q4;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q5;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q6;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q7;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q8;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q9;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q10;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q11;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q12;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q13;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q14;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q15;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q16;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q17;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q18;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q19;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q20;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q21;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q22;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q23;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q24;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q25;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q26;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q27;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q28;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q29;

    @NotNull
    @Min(0)
    @Max(2)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q30;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Rate of visual characteristics coming from the survey")
    @Column(nullable = false)
    private Short visual;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Rate of auditory characteristics coming from the survey")
    @Column(nullable = false)
    private Short auditory;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Rate of kinaesthetic characteristics coming from the survey")
    @Column(nullable = false)
    private Short kinaesthetic;

    public SurveyVak(User surveyVakUser, Integer surveyVakId, LocalDateTime submissionTime, Short q1,
                     Short q2, Short q3, Short q4, Short q5, Short q6, Short q7, Short q8,
                     Short q9, Short q10, Short q11, Short q12, Short q13, Short q14, Short q15,
                     Short q16, Short q17, Short q18, Short q19, Short q20, Short q21, Short q22,
                     Short q23, Short q24, Short q25, Short q26, Short q27, Short q28, Short q29,
                     Short q30, Short visual, Short auditory, Short kinaesthetic) {
        this.surveyVakUser = surveyVakUser;
        this.surveyVakId = surveyVakId;
        this.submissionTime = submissionTime;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.q6 = q6;
        this.q7 = q7;
        this.q8 = q8;
        this.q9 = q9;
        this.q10 = q10;
        this.q11 = q11;
        this.q12 = q12;
        this.q13 = q13;
        this.q14 = q14;
        this.q15 = q15;
        this.q16 = q16;
        this.q17 = q17;
        this.q18 = q18;
        this.q19 = q19;
        this.q20 = q20;
        this.q21 = q21;
        this.q22 = q22;
        this.q23 = q23;
        this.q24 = q24;
        this.q25 = q25;
        this.q26 = q26;
        this.q27 = q27;
        this.q28 = q28;
        this.q29 = q29;
        this.q30 = q30;
        this.visual = visual;
        this.auditory = auditory;
        this.kinaesthetic = kinaesthetic;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SurveyVak() {
    }

    public User getSurveyVakUser() {
        return surveyVakUser;
    }

    public void setSurveyVakUser(User surveyVakUser) {
        this.surveyVakUser = surveyVakUser;
    }

    public Integer getSurveyVakId() {
        return surveyVakId;
    }

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public Short getQ1() {
        return q1;
    }

    public void setQ1(Short q1) {
        this.q1 = q1;
    }

    public Short getQ2() {
        return q2;
    }

    public void setQ2(Short q2) {
        this.q2 = q2;
    }

    public Short getQ3() {
        return q3;
    }

    public void setQ3(Short q3) {
        this.q3 = q3;
    }

    public Short getQ4() {
        return q4;
    }

    public void setQ4(Short q4) {
        this.q4 = q4;
    }

    public Short getQ5() {
        return q5;
    }

    public void setQ5(Short q5) {
        this.q5 = q5;
    }

    public Short getQ6() {
        return q6;
    }

    public void setQ6(Short q6) {
        this.q6 = q6;
    }

    public Short getQ7() {
        return q7;
    }

    public void setQ7(Short q7) {
        this.q7 = q7;
    }

    public Short getQ8() {
        return q8;
    }

    public void setQ8(Short q8) {
        this.q8 = q8;
    }

    public Short getQ9() {
        return q9;
    }

    public void setQ9(Short q9) {
        this.q9 = q9;
    }

    public Short getQ10() {
        return q10;
    }

    public void setQ10(Short q10) {
        this.q10 = q10;
    }

    public Short getQ11() {
        return q11;
    }

    public void setQ11(Short q11) {
        this.q11 = q11;
    }

    public Short getQ12() {
        return q12;
    }

    public void setQ12(Short q12) {
        this.q12 = q12;
    }

    public Short getQ13() {
        return q13;
    }

    public void setQ13(Short q13) {
        this.q13 = q13;
    }

    public Short getQ14() {
        return q14;
    }

    public void setQ14(Short q14) {
        this.q14 = q14;
    }

    public Short getQ15() {
        return q15;
    }

    public void setQ15(Short q15) {
        this.q15 = q15;
    }

    public Short getQ16() {
        return q16;
    }

    public void setQ16(Short q16) {
        this.q16 = q16;
    }

    public Short getQ17() {
        return q17;
    }

    public void setQ17(Short q17) {
        this.q17 = q17;
    }

    public Short getQ18() {
        return q18;
    }

    public void setQ18(Short q18) {
        this.q18 = q18;
    }

    public Short getQ19() {
        return q19;
    }

    public void setQ19(Short q19) {
        this.q19 = q19;
    }

    public Short getQ20() {
        return q20;
    }

    public void setQ20(Short q20) {
        this.q20 = q20;
    }

    public Short getQ21() {
        return q21;
    }

    public void setQ21(Short q21) {
        this.q21 = q21;
    }

    public Short getQ22() {
        return q22;
    }

    public void setQ22(Short q22) {
        this.q22 = q22;
    }

    public Short getQ23() {
        return q23;
    }

    public void setQ23(Short q23) {
        this.q23 = q23;
    }

    public Short getQ24() {
        return q24;
    }

    public void setQ24(Short q24) {
        this.q24 = q24;
    }

    public Short getQ25() {
        return q25;
    }

    public void setQ25(Short q25) {
        this.q25 = q25;
    }

    public Short getQ26() {
        return q26;
    }

    public void setQ26(Short q26) {
        this.q26 = q26;
    }

    public Short getQ27() {
        return q27;
    }

    public void setQ27(Short q27) {
        this.q27 = q27;
    }

    public Short getQ28() {
        return q28;
    }

    public void setQ28(Short q28) {
        this.q28 = q28;
    }

    public Short getQ29() {
        return q29;
    }

    public void setQ29(Short q29) {
        this.q29 = q29;
    }

    public Short getQ30() {
        return q30;
    }

    public void setQ30(Short q30) {
        this.q30 = q30;
    }

    public Short getVisual() {
        return visual;
    }

    public void setVisual(Short visual) {
        this.visual = visual;
    }

    public Short getAuditory() {
        return auditory;
    }

    public void setAuditory(Short auditory) {
        this.auditory = auditory;
    }

    public Short getKinaesthetic() {
        return kinaesthetic;
    }

    public void setKinaesthetic(Short kinaethetic) {
        this.kinaesthetic = kinaethetic;
    }
}
