package mdx.gsd.dao;

import mdx.gsd.data.model.SensorHeartbeat;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SensorHeartbeatDAO {

    void addSensorHeartbeat(SensorHeartbeat sensorHeartbeat);

    void updateSensorHeartbeat(SensorHeartbeat sensorHeartbeat);

    SensorHeartbeat getSensorHeartbeatById(Integer id);

    List<SensorHeartbeat> getAllSensorHeartbeat();

    void removeSensorHeartbeat(Integer id);

    List<SensorHeartbeat> getUserSensorHeartbeat(String id);
}
