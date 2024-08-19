package com.bank.service;

import com.bank.model.Conta;
import org.junit.jupiter.api.Test;

public class ServicoContaTest {
    @Test
    public void testarDeposito() {
        Conta conta = new Conta("1", 100.0);
        ServicoConta servico = new ServicoConta();
        servico.depositar(conta, 50.0);

        if (conta.getSaldo() != 150.0) {
            throw new AssertionError("Saldo após depósito não está correto. Esperado: 150.0, Encontrado: " + conta.getSaldo());
        }
    }
    
    @Test
    public void testarSaque() {
        Conta conta = new Conta("1", 100.0);
        ServicoConta servico = new ServicoConta();
        servico.sacar(conta, 50.0);

        if (conta.getSaldo() != 50.0) {
            throw new AssertionError("Saldo após saque não está correto. Esperado: 50.0, Encontrado: " + conta.getSaldo());
        }
    }

    @Test
    public void testarSaqueSaldoInsuficiente() {
        Conta conta = new Conta("1", 100.0);
        ServicoConta servico = new ServicoConta();
        
        try {
            servico.sacar(conta, 150.0);
            throw new AssertionError("Esperava-se uma exceção de saldo insuficiente.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Saldo insuficiente")) {
                throw new AssertionError("Mensagem de exceção não está correta. Esperado: 'Saldo insuficiente', Encontrado: " + e.getMessage());
            }
        }
    }
}
