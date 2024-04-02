package com.estudo.estudospring.di.service;

import com.estudo.estudospring.Client;
import org.springframework.stereotype.Component;

public class NotificadorEmail {

    public NotificadorEmail() {
        System.out.println("NotificadorEmail");
    }

    public void notificar(Client cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
