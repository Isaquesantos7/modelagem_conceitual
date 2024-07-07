package com.isaquesantos7.modelagem_conceitual.model.enums;

public enum TypeClient {
    PESSOA_FISICA(100, "Pessoa Física"),
    PESSOA_JURIDICA(200, "Pessoa Jurídica"),
    ;

    private int code;
    private String description;

    TypeClient(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TypeClient toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (TypeClient x : TypeClient.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalid: " + code);
    }
}
