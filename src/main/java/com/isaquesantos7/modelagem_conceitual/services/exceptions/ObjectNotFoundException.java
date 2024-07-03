package com.isaquesantos7.modelagem_conceitual.services.exceptions;

import java.io.Serial;
import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public  ObjectNotFoundException(String msg) {
        super(msg);
    }
}
