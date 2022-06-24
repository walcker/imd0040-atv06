package br.ufrn.imd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaTelefonica implements Agenda {

    @Override
    public void salvar(Contato contato) {
        Map<String, Contato> agenda = new HashMap<>();
        agenda.put(contato.getNome(), contato);
        agenda.put(contato.getEmail(), contato);
        agenda.put(contato.getTelefones().get(0), contato);
        throw new UnsupportedOperationException("Operação não suportada");
    }

    @Override
    public Contato buscarPorEmail(String email) {
        throw new UnsupportedOperationException("Operação não suportada");
    }

    @Override
    public Contato buscarPorNome(String nome) {
        throw new UnsupportedOperationException("Operação não suportada");
    }

    public static void main(String[] args) {
        AgendaTelefonica agenda = new AgendaTelefonica();
        Contato contato = new Contato("João", "joao@gmail.com", List.of("(11) 99999-9999"));
        System.out.println(contato.getNome());
        System.out.println(contato.getEmail());
        System.out.println(contato.getTelefones().get(0));
    }

}

