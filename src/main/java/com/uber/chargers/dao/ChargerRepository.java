package com.uber.chargers.dao;

import com.uber.chargers.domain.Charger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargerRepository extends PagingAndSortingRepository<Charger, Long> {

    Charger findChargerBySession(String sessionId);

    List<Charger> getByStatus(String sessionId);

}
