package br.ufrn.imd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AgendaTest {

    private Agenda agenda = new AgendaTelefonica();

    @BeforeAll
    public void prepareData(){
        for (int i = 0;i < 500_000; i++){
            agenda.salvar(generateRandomContact());
        }
        System.out.println("CHAMOU");
    }

    private Contato generateRandomContact() {
        return new Contato(UUID.randomUUID().toString(), UUID.randomUUID().toString(), Arrays.asList(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
    }

    @Test
    void salvarContatoNovo() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
    }

    @Test
    void salvarContatoExistente() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
    }

    @Test
    void updateContato() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("999999")));
        Contato encontrado = agenda.buscarPorEmail("g@gmail.com");
        assertLinesMatch(encontrado.getTelefones(), Arrays.asList("999999"));
    }

    @Test
    void buscarPorNome() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        Contato encontrado = agenda.buscarPorNome("gustavo");
        assertSame(encontrado.getEmail(), "g@gmail.com");
        assertSame(encontrado.getNome(), "gustavo");
        assertLinesMatch(encontrado.getTelefones(), Arrays.asList("84988469690"));
    }

    @Test
    void buscarPorNomeNaoExistente() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        Contato encontrado = agenda.buscarPorNome("nao-existe");
        assertNull(encontrado);
    }

    @Test
    void buscarPorEmail() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        Contato encontrado = agenda.buscarPorEmail("g@gmail.com");
        assertSame(encontrado.getEmail(), "g@gmail.com");
        assertSame(encontrado.getNome(), "gustavo");
        assertLinesMatch(encontrado.getTelefones(), Arrays.asList("84988469690"));
    }

    @Test
    void buscarPorEmailNaoExistente() throws ClassNotFoundException {
        agenda.salvar(new Contato("gustavo", "g@gmail.com", Arrays.asList("84988469690")));
        Contato encontrado = agenda.buscarPorEmail("nao-existe");
        assertNull(encontrado);
    }

}