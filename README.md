## Atividade

Implemente a casse AgendaTelefonica de forma a satisfazer os requisitos da interface Agenda (ver javadoc).

```java
public interface Agenda {

    /**
     * Salva um novo contato na agenda. Permite apenas um contato por e-mail e nome completo. 
     * Caso já haja contato igual (mesmo e-mail ou nome) deve ser substituído.
     * @param contato Contato a ser salvo
     */
    void salvar(Contato contato);

    /**
     * Busca contato a partir de um e-mail
     * @param email e-mail a ser buscado
     * @return O Contato localizado ou null se inexistente.
     */
    Contato buscarPorEmail(String email);

    /**
     * Busca o contato a partir do nome.
     * @param nome Nome a ser buscado
     * @return O Contato localizado ou null se inexistente
     */
    Contato buscarPorNome(String nome);

}
```


Pontos de atenção:

1. Utilize estrutura de dados Map para armazenar os dados de contato
2. Faça adaptações na Classse Contato, caso necesário

## Testes

O programa possui testes automatizados implementados. Se quiser testar execute o seguinte comando:

```console
$ ./gradlew test
```