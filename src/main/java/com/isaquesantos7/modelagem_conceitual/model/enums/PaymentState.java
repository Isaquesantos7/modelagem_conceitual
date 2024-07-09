package com.isaquesantos7.modelagem_conceitual.model.enums;

public enum PaymentState {
    PENDING(1, "ORDER PENDING PAYMENT"),
    PAID(2, "ORDER PAID"),
    CANCELED(3, "ORDER CANCELED");

    private final Integer code;
    private final String description;

    PaymentState(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentState toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (PaymentState x : PaymentState.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalid! " + code);
    }
}
