package com.sdm.emergency_dispatcher_center.service;

import com.sdm.emergency_dispatcher_center.domain.Dispatcher;
import com.sdm.emergency_dispatcher_center.domain.EmergencyUnit;
import com.sdm.emergency_dispatcher_center.domain.User;

public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private boolean success;
    private String type;
    private String unitType;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.success = true;
        this.type = user.getClass().getSimpleName();
        this.unitType = (user instanceof EmergencyUnit) ? ((EmergencyUnit)user).getUnitType().toString() : "";
    }

    public User toUser() {
        if (Dispatcher.class.getSimpleName().equals(this.type)) {
            return new Dispatcher(userName, password, email, id);
        } else {
            return new User(userName, password, email, id);
        }
    }
}
