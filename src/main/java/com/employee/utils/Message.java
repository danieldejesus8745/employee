package com.employee.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Message {

    MESSAGE_1("Funcionário adicionado com sucesso");

    private final String message;

}
