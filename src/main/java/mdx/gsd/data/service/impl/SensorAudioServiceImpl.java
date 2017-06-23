package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SensorAudioDAO;
import mdx.gsd.data.model.SensorAudio;
import mdx.gsd.data.service.SensorAudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SensorAudioServiceImpl implements SensorAudioService {

    private final SensorAudioDAO sensorAudioDAO;

    @Autowired
    public SensorAudioServiceImpl(SensorAudioDAO sensorAudioDAO) {
        this.sensorAudioDAO = sensorAudioDAO;
    }


    @Override
    @Transactional
    public void addSensorAudio(SensorAudio sensorAudio) {
        this.sensorAudioDAO.addSensorAudio(sensorAudio);
    }

    @Override
    @Transactional
    public void updateSensorAudio(SensorAudio sensorAudio) {
        this.sensorAudioDAO.updateSensorAudio(sensorAudio);
    }

    @Override
    @Transactional
    public SensorAudio getSensorAudioById(Integer id) {
        return this.sensorAudioDAO.getSensorAudioById(id);
    }

    @Override
    @Transactional
    public List<SensorAudio> getUserSensorAudio(String id) {
        return this.sensorAudioDAO.getUserSensorAudio(id);
    }

    @Override
    @Transactional
    public List<SensorAudio> getAllSensorAudio() {
        return this.sensorAudioDAO.getAllSensorAudio();
    }

    @Override
    @Transactional
    public void removeSensorAudio(Integer id) {
        this.sensorAudioDAO.removeSensorAudio(id);
    }

}
