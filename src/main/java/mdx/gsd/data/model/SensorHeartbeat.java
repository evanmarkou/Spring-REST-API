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
@Table(name = "SensorHeartbeat")
public class SensorHeartbeat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database auto-generated Sensor Heartbeat ID")
    private Integer sensorHeartbeatId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @ApiModelProperty(notes = "Refers to the User object, having all the user details")
    private User sensorHeartbeatUser;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Precise time of SensorEmotion data insertion")
    private LocalDateTime timestamp;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ApiModelProperty(notes = "The rate level coming from the sensor", required = true)
    private Short rate;

    public SensorHeartbeat(User sensorHeartbeatUser, Integer sensorHeartbeatId, LocalDateTime timestamp, Short rate) {
        this.sensorHeartbeatUser = sensorHeartbeatUser;
        this.sensorHeartbeatId = sensorHeartbeatId;
        this.timestamp = timestamp;
        this.rate = rate;
    }

    //JPA 2.0 Prerequisite. For further details check in specification handbook***
    public SensorHeartbeat() {
    }

    public User getSensorHeartbeatUser() {
        return sensorHeartbeatUser;
    }

    public void setSensorHeartbeatUser(User sensorHeartbeatUser) {
        this.sensorHeartbeatUser = sensorHeartbeatUser;
    }

    public Integer getSensorHeartbeatId() {
        return sensorHeartbeatId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Short getRate() {
        return rate;
    }

    public void setRate(Short rate) {
        this.rate = rate;
    }
}
