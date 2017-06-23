package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SensorEmotionDAO;
import mdx.gsd.data.model.SensorEmotion;
import mdx.gsd.data.service.SensorEmotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SensorEmotionServiceImpl implements SensorEmotionService {

    private final SensorEmotionDAO sensorEmotionDAO;

    @Autowired
    public SensorEmotionServiceImpl(SensorEmotionDAO sensorEmotionDAO) {
        this.sensorEmotionDAO = sensorEmotionDAO;
    }

    @Override
    @Transactional
    public void addSensorEmotion(SensorEmotion sensorEmotion) {
        this.sensorEmotionDAO.addSensorEmotion(sensorEmotion);
    }

    @Override
    @Transactional
    public void updateSensorEmotion(SensorEmotion sensorEmotion) {
        this.sensorEmotionDAO.updateSensorEmotion(sensorEmotion);
    }

    @Override
    @Transactional
    public SensorEmotion getSensorEmotionById(Integer id) {
        return this.sensorEmotionDAO.getSensorEmotionById(id);
    }

    @Override
    @Transactional
    public List<SensorEmotion> getUserSensorEmotion(String id) {
        return this.sensorEmotionDAO.getUserSensorEmotion(id);
    }

    @Override
    @Transactional
    public List<SensorEmotion> getAllSensorEmotion() {
        return this.sensorEmotionDAO.getAllSensorEmotion();
    }

    @Override
    @Transactional
    public void removeSensorEmotion(Integer id) {
        this.sensorEmotionDAO.removeSensorEmotion(id);
    }
}
