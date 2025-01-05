package com.project.IndiaCenter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Role {
    USER,
    ADMIN,
    DEV;

    @JsonCreator
    public static Role fromString(String role) {
        return Role.valueOf(role.toUpperCase());
    }

    @JsonValue
    public String getValue() {
        return this.name();
    }
}
