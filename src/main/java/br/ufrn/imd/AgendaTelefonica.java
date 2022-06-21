package br.ufrn.imd;

public class AgendaTelefonica implements Agenda {

    @Override
    public void salvar(Contato contato) {
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

}
