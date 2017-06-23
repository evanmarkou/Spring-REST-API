package mdx.gsd.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Integer moduleId;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    @NotEmpty
    @Column(nullable = false)
    private String lastName;

    @NotEmpty
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role assignRole;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorHeartbeatUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SensorHeartbeat> sensorHeartbeat;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorEmotionUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SensorEmotion> sensorEmotion;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorSweatUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SensorSweat> sensorSweat;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorAudioUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SensorAudio> sensorAudio;

    @JsonIgnore
    @OneToMany(mappedBy = "surveyBelbinUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SurveyBelbin> surveyBelbin;

    @JsonIgnore
    @OneToMany(mappedBy = "surveyMbtiUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SurveyMbti> surveyMbti;

    @JsonIgnore
    @OneToMany(mappedBy = "surveyVakUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SurveyVak> surveyVak;

    @JsonIgnore
    @OneToMany(mappedBy = "surveyPaeiUser")
    @Cascade({CascadeType.SAVE_UPDATE})
    private Collection<SurveyPaei> surveyPaei;

    public User(Role assignRole, Collection<SensorHeartbeat> sensorHeartbeat,
                Collection<SensorEmotion> sensorEmotion, Collection<SensorSweat> sensorSweat,
                Collection<SensorAudio> sensorAudio, Collection<SurveyBelbin> surveyBelbin,
                Collection<SurveyMbti> surveyMbti, Collection<SurveyVak> surveyVak,
                Collection<SurveyPaei> surveyPaei, String userId, Integer moduleId,
                String firstName, String lastName, String email, Boolean gender) {

        this.assignRole = assignRole;
        this.sensorHeartbeat = sensorHeartbeat;
        this.sensorEmotion = sensorEmotion;
        this.sensorSweat = sensorSweat;
        this.sensorAudio = sensorAudio;
        this.surveyBelbin = surveyBelbin;
        this.surveyMbti = surveyMbti;
        this.surveyVak = surveyVak;
        this.surveyPaei = surveyPaei;
        this.userId = userId;
        this.moduleId = moduleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public User() {
    }


    public Role getRole() {
        return assignRole;
    }

    public void setRole(Role assignRole) {
        this.assignRole = assignRole;
    }

    public Collection<SensorHeartbeat> getSensorHeartbeat() {
        return sensorHeartbeat;
    }

    public void setSensorHeartbeat(Collection<SensorHeartbeat> sensorHeartbeat) {
        this.sensorHeartbeat = sensorHeartbeat;
    }

    public Collection<SensorEmotion> getSensorEmotion() {
        return sensorEmotion;
    }

    public void setSensorEmotion(Collection<SensorEmotion> sensorEmotion) {
        this.sensorEmotion = sensorEmotion;
    }

    public Collection<SensorSweat> getSensorSweat() {
        return sensorSweat;
    }

    public void setSensorSweat(Collection<SensorSweat> sensorSweat) {
        this.sensorSweat = sensorSweat;
    }

    public Collection<SensorAudio> getSensorAudio() {
        return sensorAudio;
    }

    public void setSensorAudio(Collection<SensorAudio> sensorAudio) {
        this.sensorAudio = sensorAudio;
    }

    public Collection<SurveyBelbin> getSurveyBelbin() {
        return surveyBelbin;
    }

    public void setSurveyBelbin(Collection<SurveyBelbin> surveyBelbin) {
        this.surveyBelbin = surveyBelbin;
    }

    public Collection<SurveyMbti> getSurveyMbti() {
        return surveyMbti;
    }

    public void setSurveyMbti(Collection<SurveyMbti> surveyMbti) {
        this.surveyMbti = surveyMbti;
    }

    public Collection<SurveyVak> getSurveyVak() {
        return surveyVak;
    }

    public void setSurveyVak(Collection<SurveyVak> surveyVak) {
        this.surveyVak = surveyVak;
    }

    public Collection<SurveyPaei> getSurveyPaei() {
        return surveyPaei;
    }

    public void setSurveyPaei(Collection<SurveyPaei> surveyPaei) {
        this.surveyPaei = surveyPaei;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}