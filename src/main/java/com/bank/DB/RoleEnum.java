package com.bank.DB;

import com.bank.DTO.ru.cbr.ed.leaftypes.v2.RstrType;

public enum RoleEnum {
    ADMIN,
    USER;

    public String value() {
        return name();
    }

    public static RoleEnum fromValue(String v) {
        return valueOf(v);
    }
}
