package mdx.gsd.data.service;

import mdx.gsd.data.model.SensorSweat;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SensorSweatService {

    void addSensorSweat(SensorSweat sensorSweat);

    void updateSensorSweat(SensorSweat sensorSweat);

    SensorSweat getSensorSweatById(Integer id);

    List<SensorSweat> getAllSensorSweat();

    List<SensorSweat> getUserSensorSweat(String id);

    void removeSensorSweat(Integer id);
}
