package com.bank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    private String idTransacao;
    private Conta conta;
    private double valor;
    private String tipo; // "DEPOSITO" ou "SAQUE"
}
