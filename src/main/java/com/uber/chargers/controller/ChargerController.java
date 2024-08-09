package com.uber.chargers.controller;

import com.uber.chargers.domain.Charger;
import com.uber.chargers.domain.EChargerStatus;
import com.uber.chargers.exception.HandlerException;
import com.uber.chargers.service.ChargerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;


@RestController
@RequestMapping(value = "/api/charger")
@Api(tags = {"charger"})
public class ChargerController extends HandlerException {

    @Autowired
    private ChargerService chargerService;

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get session Id.")
    public ResponseEntity<String> validateSession() {
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        return new ResponseEntity<>("New session " + sessionId, HttpStatus.OK);
    }

    @RequestMapping(value = "/available",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Result of the available chargers.")
    public ResponseEntity<String> available() throws Exception {
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        List<Charger> availableChargers = this.chargerService.getByStatus(EChargerStatus.AVAILABLE.getStatus());
        return new ResponseEntity<>("Result: " + availableChargers.size()
                + " - User: " + sessionId, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single charger by id.")
    public ResponseEntity<Charger> getCharger(@ApiParam(value = "The id of the charger.", required = true)
                                                  @PathVariable("id") Long id) throws Exception {
        Charger charger = this.chargerService.getCharger(id);
        checkResourceFound(charger);
        return new ResponseEntity<>(charger, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a charger.")
    public ResponseEntity<String> addCharger(@ApiParam(name = "id", value = "Argument id", required = true) @PathVariable("id") int id) {
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        this.chargerService.saveCharger(createCharger(sessionId, id));
        return new ResponseEntity<>("Registered charger " + id, HttpStatus.OK);
    }

    private Charger createCharger(String session, int id) {
        return new Charger(session, id, EChargerStatus.AVAILABLE.getStatus());
    }

}
