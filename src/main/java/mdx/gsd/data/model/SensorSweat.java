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
@Table(name = "SensorSweat")
public class SensorSweat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Sensor Sweat ID")
    private Integer sensorSweatId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User sensorSweatUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SensorEmotion data insertion")
    private LocalDateTime timestamp;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The sweat level coming from the sensor")
    private Short sweatlevel;

    public SensorSweat(User sensorSweatUser, Integer sensorSweatId, LocalDateTime timestamp, Short sweatlevel) {
        this.sensorSweatUser = sensorSweatUser;
        this.sensorSweatId = sensorSweatId;
        this.timestamp = timestamp;
        this.sweatlevel = sweatlevel;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SensorSweat() {
    }

    public User getSensorSweatUser() {
        return sensorSweatUser;
    }

    public void setSensorSweatUser(User sensorSweatUser) {
        this.sensorSweatUser = sensorSweatUser;
    }

    public Integer getSensorSweatId() {
        return sensorSweatId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Short getSweatlevel() {
        return sweatlevel;
    }

    public void setSweatlevel(Short sweatlevel) {
        this.sweatlevel = sweatlevel;
    }
}
