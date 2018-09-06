package com.sdm.emergency_dispatcher_center.domain;

public enum OperationType {
    FireEmergency(0), MedicalEmergency(1), PoliceEmergency(2);

    int emergencyType;

    OperationType(int emergencyType) {
        this.emergencyType = emergencyType;
    }

    public int getEmergencyType() {
        return emergencyType;
    }
}
