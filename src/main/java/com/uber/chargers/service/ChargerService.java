package com.uber.chargers.service;

import com.uber.chargers.dao.ChargerRepository;
import com.uber.chargers.domain.Charger;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargerService {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChargerRepository chargerRepository;

    public Charger getChargerBySession(String sessionId) {
        return chargerRepository.findChargerBySession(sessionId);
    }

    public Charger getCharger(long id) {
        return chargerRepository.findOne(id);
    }

    public List<Charger> getByStatus(String status) {
        return chargerRepository.getByStatus(status);
    }

    public Charger saveCharger(Charger charger) {
        return chargerRepository.save(charger);
    }


}
