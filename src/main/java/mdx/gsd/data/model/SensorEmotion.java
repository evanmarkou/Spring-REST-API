package mdx.gsd.data.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Entity
@Table(name = "SensorEmotion")
public class SensorEmotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Sensor Emotion ID")
    private Integer sensorEmotionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User sensorEmotionUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SensorEmotion data insertion")
    private LocalDateTime timestamp;

    @NotEmpty
    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The dominant emotion coming from the sensor", required = true)
    private String dominantEmotion;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The score of the dominant emotion", required = true)
    private Short score;

    public SensorEmotion(User sensorEmotionUser, Integer sensorEmotionId, LocalDateTime timestamp, String dominantEmotion, Short score) {
        this.sensorEmotionUser = sensorEmotionUser;
        this.sensorEmotionId = sensorEmotionId;
        this.timestamp = timestamp;
        this.dominantEmotion = dominantEmotion;
        this.score = score;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SensorEmotion() {
    }

    public User getSensorEmotionUser() {
        return sensorEmotionUser;
    }

    public void setSensorEmotionUser(User sensorEmotionUser) {
        this.sensorEmotionUser = sensorEmotionUser;
    }

    public Integer getSensorEmotionId() {
        return sensorEmotionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDominantEmotion() {
        return dominantEmotion;
    }

    public void setDominantEmotion(String dominantEmotion) {
        this.dominantEmotion = dominantEmotion;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
}
