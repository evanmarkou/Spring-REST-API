package mdx.gsd.data.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Entity
@Table(name = "SensorAudio")
public class SensorAudio implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Sensor Audio ID")
    private Integer sensorAudioId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User sensorAudioUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SensorAudio data insertion")
    private LocalDateTime timestamp;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The angle coming from the sensor", required = true)
    private Short angle;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The energy level coming from the sensor", required = true)
    private Short energy;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The confidence level coming from the sensor", required = true)
    private Short confidence;

    public SensorAudio(User sensorAudioUser, Integer sensorAudioId, LocalDateTime timestamp, Short angle, Short energy, Short confidence) {
        this.sensorAudioUser = sensorAudioUser;
        this.sensorAudioId = sensorAudioId;
        this.timestamp = timestamp;
        this.angle = angle;
        this.energy = energy;
        this.confidence = confidence;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SensorAudio() {
    }

    public User getSensorAudioUser() {
        return sensorAudioUser;
    }

    public void setSensorAudioUser(User sensorAudioUser) {
        this.sensorAudioUser = sensorAudioUser;
    }

    public Integer getSensorAudioId() {
        return sensorAudioId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Short getAngle() {
        return angle;
    }

    public void setAngle(Short angle) {
        this.angle = angle;
    }

    public Short getEnergy() {
        return energy;
    }

    public void setEnergy(Short energy) {
        this.energy = energy;
    }

    public Short getConfidence() {
        return confidence;
    }

    public void setConfidence(Short confidence) {
        this.confidence = confidence;
    }
}
