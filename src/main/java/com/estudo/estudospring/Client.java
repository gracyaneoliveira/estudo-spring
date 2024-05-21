package com.estudo.estudospring;

import java.util.Objects;

public class Client {

    private String nome;
    private String email;
    private String telefone;
    private boolean ativo = false;

    public Client() {
    }

    public Client(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void ativar() {
        this.ativo = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public static void main(String[] args) {
        var c1 = new Client();
        c1.setEmail("email");
        c1.setNome("1");

        var c2 = new Client();
        c2.setEmail("email");
        c2.setNome("2");

        System.out.println(c1.equals(c2));
    }

}
