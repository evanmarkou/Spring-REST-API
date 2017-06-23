package mdx.gsd.dao;

import mdx.gsd.data.model.SensorEmotion;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SensorEmotionDAO {

    void addSensorEmotion(SensorEmotion sensorEmotion);

    void updateSensorEmotion(SensorEmotion sensorEmotion);

    SensorEmotion getSensorEmotionById(Integer id);

    List<SensorEmotion> getAllSensorEmotion();

    List<SensorEmotion> getUserSensorEmotion(String id);

    void removeSensorEmotion(Integer id);
}
