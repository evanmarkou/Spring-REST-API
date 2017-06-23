package mdx.gsd.data.service.impl;

import mdx.gsd.dao.SensorHeartbeatDAO;
import mdx.gsd.data.model.SensorHeartbeat;
import mdx.gsd.data.service.SensorHeartbeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by universe (E.) on 12/06/17.
 */

@Service
public class SensorHeartbeatServiceImpl implements SensorHeartbeatService {

    private final SensorHeartbeatDAO sensorHeartbeatDAO;

    @Autowired
    public SensorHeartbeatServiceImpl(SensorHeartbeatDAO sensorHeartbeatDAO) {
        this.sensorHeartbeatDAO = sensorHeartbeatDAO;
    }

    @Override
    @Transactional
    public void addSensorHeartbeat(SensorHeartbeat sensorHeartbeat) {
        this.sensorHeartbeatDAO.addSensorHeartbeat(sensorHeartbeat);
    }

    @Override
    @Transactional
    public void updateSensorHeartbeat(SensorHeartbeat sensorHeartbeat) {
        this.sensorHeartbeatDAO.updateSensorHeartbeat(sensorHeartbeat);
    }

    @Override
    @Transactional
    public SensorHeartbeat getSensorHeartbeatById(Integer id) {
        return this.sensorHeartbeatDAO.getSensorHeartbeatById(id);
    }

    @Override
    @Transactional
    public List<SensorHeartbeat> getUserSensorHeartbeat(String id) {
        return this.sensorHeartbeatDAO.getUserSensorHeartbeat(id);
    }

    @Override
    @Transactional
    public List<SensorHeartbeat> getAllSensorHeartbeat() {
        return this.sensorHeartbeatDAO.getAllSensorHeartbeat();
    }

    @Override
    @Transactional
    public void removeSensorHeartbeat(Integer id) {
        this.sensorHeartbeatDAO.removeSensorHeartbeat(id);
    }
}
