package com.bank.service;

import com.bank.model.Conta;

public class ServicoConta {
    public void depositar(Conta conta, double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }

    public void sacar(Conta conta, double valor) {
        if (valor <= conta.getSaldo()) {
            conta.setSaldo(conta.getSaldo() - valor);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }
}
