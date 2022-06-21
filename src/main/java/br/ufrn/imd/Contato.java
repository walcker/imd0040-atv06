package br.ufrn.imd;

import java.util.List;

public class Contato {

    private String nome;

    private String email;

    private List<String> telefones;

    public Contato(String nome, String email, List<String> telefones) {
        this.nome = nome;
        this.email = email;
        this.telefones = telefones;
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

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

}
