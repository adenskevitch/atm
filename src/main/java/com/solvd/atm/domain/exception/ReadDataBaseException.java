package com.solvd.atm.domain.exception;

import java.sql.SQLException;

public class ReadDataBaseException extends SQLException {

    public ReadDataBaseException(String msg) {
        super(msg);
    }
}
