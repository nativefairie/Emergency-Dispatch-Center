package com.sdm.emergency_dispatcher_center.domain;

public enum OperationPriority {
    Low(0), Medium(1), High(2);

    int emergencyPriority;

    OperationPriority(int emergencyPriority) {
        this.emergencyPriority = emergencyPriority;
    }

    public int getEmergencyPriority() {
        return emergencyPriority;
    }
}
