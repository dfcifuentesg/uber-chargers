package com.uber.chargers.domain;

public enum EChargerStatus
{
    AVAILABLE("available"),
    ASSIGNED("assigned"),
    IN_MAINTENANCE("in_maintenance"),
    ;

    private String status;

    EChargerStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

