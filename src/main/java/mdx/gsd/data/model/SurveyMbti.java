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
@Table(name = "SurveyMbti")
public class SurveyMbti implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Survey Mbti ID")
    private Integer surveyMbtiId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User surveyMbtiUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SurveyMbti data insertion")
    private LocalDateTime submissionTime;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q1;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q2;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q3;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q4;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q5;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q6;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q7;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q8;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q9;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q10;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q11;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q12;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q13;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q14;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q15;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q16;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q17;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q18;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q19;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q20;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q21;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q22;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q23;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q24;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q25;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q26;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q27;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q28;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q29;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q30;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q31;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q32;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q33;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q34;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q35;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q36;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q37;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q38;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q39;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q40;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q41;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q42;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q43;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q44;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q45;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q46;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q47;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q48;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q49;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q50;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q51;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q52;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q53;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q54;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q55;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q56;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q57;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q58;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q59;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q60;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q61;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q62;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q63;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q64;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q65;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q66;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q67;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q68;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q69;

    @NotNull
    @Min(0)
    @Max(1)
    @ApiModelProperty(notes = "Multiple Choice Question from the survey")
    @Column(nullable = false)
    private Short q70;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short e;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short i;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short s;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short n;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short t;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short f;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short j;

    @NotNull
    @Min(0)
    @ApiModelProperty(notes = "Personal letter result coming from the survey")
    @Column(nullable = false)
    private Short p;

    public SurveyMbti(User surveyMbtiUser, Integer surveyMbtiId, LocalDateTime submissionTime, Short q1, Short q2,
                      Short q3, Short q4, Short q5, Short q6, Short q7, Short q8,
                      Short q9, Short q10, Short q11, Short q12, Short q13, Short q14, Short q15,
                      Short q16, Short q17, Short q18, Short q19, Short q20, Short q21, Short q22,
                      Short q23, Short q24, Short q25, Short q26, Short q27, Short q28, Short q29, Short q30,
                      Short q31, Short q32, Short q33, Short q34, Short q35, Short q36, Short q37, Short q38,
                      Short q39, Short q40, Short q41, Short q42, Short q43, Short q44, Short q45, Short q46,
                      Short q47, Short q48, Short q49, Short q50, Short q51, Short q52, Short q53, Short q54,
                      Short q55, Short q56, Short q57, Short q58, Short q59, Short q60, Short q61, Short q62,
                      Short q63, Short q64, Short q65, Short q66, Short q67, Short q68, Short q69, Short q70,
                      Short e, Short i, Short s, Short n, Short t, Short f, Short j, Short p) {
        this.surveyMbtiUser = surveyMbtiUser;
        this.surveyMbtiId = surveyMbtiId;
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
        this.q31 = q31;
        this.q32 = q32;
        this.q33 = q33;
        this.q34 = q34;
        this.q35 = q35;
        this.q36 = q36;
        this.q37 = q37;
        this.q38 = q38;
        this.q39 = q39;
        this.q40 = q40;
        this.q41 = q41;
        this.q42 = q42;
        this.q43 = q43;
        this.q44 = q44;
        this.q45 = q45;
        this.q46 = q46;
        this.q47 = q47;
        this.q48 = q48;
        this.q49 = q49;
        this.q50 = q50;
        this.q51 = q51;
        this.q52 = q52;
        this.q53 = q53;
        this.q54 = q54;
        this.q55 = q55;
        this.q56 = q56;
        this.q57 = q57;
        this.q58 = q58;
        this.q59 = q59;
        this.q60 = q60;
        this.q61 = q61;
        this.q62 = q62;
        this.q63 = q63;
        this.q64 = q64;
        this.q65 = q65;
        this.q66 = q66;
        this.q67 = q67;
        this.q68 = q68;
        this.q69 = q69;
        this.q70 = q70;
        this.e = e;
        this.i = i;
        this.s = s;
        this.n = n;
        this.t = t;
        this.f = f;
        this.j = j;
        this.p = p;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SurveyMbti() {
    }

    public User getSurveyMbtiUser() {
        return surveyMbtiUser;
    }

    public void setSurveyMbtiUser(User surveyMbtiUser) {
        this.surveyMbtiUser = surveyMbtiUser;
    }

    public Integer getSurveyMbtiId() {
        return surveyMbtiId;
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

    public Short getQ31() {
        return q31;
    }

    public void setQ31(Short q31) {
        this.q31 = q31;
    }

    public Short getQ32() {
        return q32;
    }

    public void setQ32(Short q32) {
        this.q32 = q32;
    }

    public Short getQ33() {
        return q33;
    }

    public void setQ33(Short q33) {
        this.q33 = q33;
    }

    public Short getQ34() {
        return q34;
    }

    public void setQ34(Short q34) {
        this.q34 = q34;
    }

    public Short getQ35() {
        return q35;
    }

    public void setQ35(Short q35) {
        this.q35 = q35;
    }

    public Short getQ36() {
        return q36;
    }

    public void setQ36(Short q36) {
        this.q36 = q36;
    }

    public Short getQ37() {
        return q37;
    }

    public void setQ37(Short q37) {
        this.q37 = q37;
    }

    public Short getQ38() {
        return q38;
    }

    public void setQ38(Short q38) {
        this.q38 = q38;
    }

    public Short getQ39() {
        return q39;
    }

    public void setQ39(Short q39) {
        this.q39 = q39;
    }

    public Short getQ40() {
        return q40;
    }

    public void setQ40(Short q40) {
        this.q40 = q40;
    }

    public Short getQ41() {
        return q41;
    }

    public void setQ41(Short q41) {
        this.q41 = q41;
    }

    public Short getQ42() {
        return q42;
    }

    public void setQ42(Short q42) {
        this.q42 = q42;
    }

    public Short getQ43() {
        return q43;
    }

    public void setQ43(Short q43) {
        this.q43 = q43;
    }

    public Short getQ44() {
        return q44;
    }

    public void setQ44(Short q44) {
        this.q44 = q44;
    }

    public Short getQ45() {
        return q45;
    }

    public void setQ45(Short q45) {
        this.q45 = q45;
    }

    public Short getQ46() {
        return q46;
    }

    public void setQ46(Short q46) {
        this.q46 = q46;
    }

    public Short getQ47() {
        return q47;
    }

    public void setQ47(Short q47) {
        this.q47 = q47;
    }

    public Short getQ48() {
        return q48;
    }

    public void setQ48(Short q48) {
        this.q48 = q48;
    }

    public Short getQ49() {
        return q49;
    }

    public void setQ49(Short q49) {
        this.q49 = q49;
    }

    public Short getQ50() {
        return q50;
    }

    public void setQ50(Short q50) {
        this.q50 = q50;
    }

    public Short getQ51() {
        return q51;
    }

    public void setQ51(Short q51) {
        this.q51 = q51;
    }

    public Short getQ52() {
        return q52;
    }

    public void setQ52(Short q52) {
        this.q52 = q52;
    }

    public Short getQ53() {
        return q53;
    }

    public void setQ53(Short q53) {
        this.q53 = q53;
    }

    public Short getQ54() {
        return q54;
    }

    public void setQ54(Short q54) {
        this.q54 = q54;
    }

    public Short getQ55() {
        return q55;
    }

    public void setQ55(Short q55) {
        this.q55 = q55;
    }

    public Short getQ56() {
        return q56;
    }

    public void setQ56(Short q56) {
        this.q56 = q56;
    }

    public Short getQ57() {
        return q57;
    }

    public void setQ57(Short q57) {
        this.q57 = q57;
    }

    public Short getQ58() {
        return q58;
    }

    public void setQ58(Short q58) {
        this.q58 = q58;
    }

    public Short getQ59() {
        return q59;
    }

    public void setQ59(Short q59) {
        this.q59 = q59;
    }

    public Short getQ60() {
        return q60;
    }

    public void setQ60(Short q60) {
        this.q60 = q60;
    }

    public Short getQ61() {
        return q61;
    }

    public void setQ61(Short q61) {
        this.q61 = q61;
    }

    public Short getQ62() {
        return q62;
    }

    public void setQ62(Short q62) {
        this.q62 = q62;
    }

    public Short getQ63() {
        return q63;
    }

    public void setQ63(Short q63) {
        this.q63 = q63;
    }

    public Short getQ64() {
        return q64;
    }

    public void setQ64(Short q64) {
        this.q64 = q64;
    }

    public Short getQ65() {
        return q65;
    }

    public void setQ65(Short q65) {
        this.q65 = q65;
    }

    public Short getQ66() {
        return q66;
    }

    public void setQ66(Short q66) {
        this.q66 = q66;
    }

    public Short getQ67() {
        return q67;
    }

    public void setQ67(Short q67) {
        this.q67 = q67;
    }

    public Short getQ68() {
        return q68;
    }

    public void setQ68(Short q68) {
        this.q68 = q68;
    }

    public Short getQ69() {
        return q69;
    }

    public void setQ69(Short q69) {
        this.q69 = q69;
    }

    public Short getQ70() {
        return q70;
    }

    public void setQ70(Short q70) {
        this.q70 = q70;
    }

    public Short getE() {
        return e;
    }

    public void setE(Short e) {
        this.e = e;
    }

    public Short getI() {
        return i;
    }

    public void setI(Short i) {
        this.i = i;
    }

    public Short getS() {
        return s;
    }

    public void setS(Short s) {
        this.s = s;
    }

    public Short getN() {
        return n;
    }

    public void setN(Short n) {
        this.n = n;
    }

    public Short getT() {
        return t;
    }

    public void setT(Short t) {
        this.t = t;
    }

    public Short getF() {
        return f;
    }

    public void setF(Short f) {
        this.f = f;
    }

    public Short getJ() {
        return j;
    }

    public void setJ(Short j) {
        this.j = j;
    }

    public Short getP() {
        return p;
    }

    public void setP(Short p) {
        this.p = p;
    }
}
