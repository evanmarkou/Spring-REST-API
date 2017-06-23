package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SensorSweatDAO;
import mdx.gsd.data.model.SensorSweat;
import mdx.gsd.data.service.SensorSweatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SensorSweatServiceImpl implements SensorSweatService {

    private final SensorSweatDAO sensorSweatDAO;

    @Autowired
    public SensorSweatServiceImpl(SensorSweatDAO sensorSweatDAO) {
        this.sensorSweatDAO = sensorSweatDAO;
    }

    @Override
    @Transactional
    public void addSensorSweat(SensorSweat sensorSweat) {
        this.sensorSweatDAO.addSensorSweat(sensorSweat);
    }

    @Override
    @Transactional
    public void updateSensorSweat(SensorSweat sensorSweat) {
        this.sensorSweatDAO.updateSensorSweat(sensorSweat);
    }

    @Override
    @Transactional
    public SensorSweat getSensorSweatById(Integer id) {
        return this.sensorSweatDAO.getSensorSweatById(id);
    }

    @Override
    @Transactional
    public List<SensorSweat> getAllSensorSweat() {
        return this.sensorSweatDAO.getAllSensorSweat();
    }

    @Override
    @Transactional
    public List<SensorSweat> getUserSensorSweat(String id) {
        return this.sensorSweatDAO.getUserSensorSweat(id);
    }

    @Override
    @Transactional
    public void removeSensorSweat(Integer id) {
        this.sensorSweatDAO.removeSensorSweat(id);
    }
}
