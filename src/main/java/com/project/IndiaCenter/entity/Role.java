package com.project.IndiaCenter.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Role {
    ADMIN(1L, "ADMIN"),
    LIBRARIAN(2L, "LIBRARIAN"),
    READER(3L, "READER");

    private final Long id;
    private final String name;

    Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonCreator
    public static Role fromString(String role) {
        for (Role r : Role.values()) {
            if (r.getName().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No role found with name: " + role);
    }

    @JsonValue
    public String getValue() {
        return this.name;
    }
}
