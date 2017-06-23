package mdx.gsd.data.service;

import mdx.gsd.data.model.SensorEmotion;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

public interface SensorEmotionService {

    void addSensorEmotion(SensorEmotion sensorEmotion);

    void updateSensorEmotion(SensorEmotion sensorEmotion);

    SensorEmotion getSensorEmotionById(Integer id);

    List<SensorEmotion> getUserSensorEmotion(String id);

    List<SensorEmotion> getAllSensorEmotion();

    void removeSensorEmotion(Integer id);

}
