package com.sdm.emergency_dispatcher_center.service;

import java.util.List;

public class OperationsDto {
    private List<OperationDto> operations;
    private boolean success = true;

    public OperationsDto(List<OperationDto> operations) {
        this.operations = operations;
    }
}
