package com.dwyw.config.data;

import lombok.Setter;

@Setter
public class UserSession {

    private String authorization;

    @Override
    public String toString() {
        return "UserSession{" +
            "authorization='" + authorization + '\'' +
            '}';
    }
}
