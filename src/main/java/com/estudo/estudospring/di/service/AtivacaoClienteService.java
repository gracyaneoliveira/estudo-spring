package com.estudo.estudospring.di.service;

import com.estudo.estudospring.Client;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private final NotificadorEmail notificadorEmail;

    public AtivacaoClienteService() {
        System.out.println("AtivacaoClienteService");
        this.notificadorEmail = new NotificadorEmail();
    }

    public void ativar(Client client) {
        client.ativar();

        notificadorEmail.notificar(client, "Seu cadastro no sistema está ativo!");
    }
}

