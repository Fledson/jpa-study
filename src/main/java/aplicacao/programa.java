package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class programa {

    public static void main(String[] args) {

        /**
         * Instanciando objetos de pessoas para adicionar ao banco de dados
         */
        /**
         *  Pessoa p1 = new Pessoa(null, "João", "João@gmail.com");
         *  Pessoa p2 = new Pessoa(null, "Maria", "Maria@gmail.com");
         *  Pessoa p3 = new Pessoa(null, "José", "José@gmail.com");
         */

        /**
         * Instanciando o EntityManagerFactory com as configurações do banco de dados continas em META-INF > persistence.xml
         */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        /**
         *  Instanciando a conexão com o banco de dados
         */
        EntityManager em = emf.createEntityManager();



        /**
         * ========= Salvando os dados no banco de dados =========
         */
        /**
         * // Iniciando uma transação com o banco de dados
         * em.getTransaction().begin();
         *
         * em.persist(p1); // persist pega o objeto passado por parametro e cria no banco de dados
         * em.persist(p2); // persist pega o objeto passado por parametro e cria no banco de dados
         * em.persist(p3); // persist pega o objeto passado por parametro e cria no banco de dados
         *
         *  em.getTransaction().commit(); // Confirmando as auterações
         */

        /**
         * BUSCANDO OBJETOS NO BANCO VIA JPA
         */
        Pessoa pessoaEncontradaNoBanco = em.find(Pessoa.class, 1);

        /**
         * DELETANDO OBJETO DO BANCO DE DADOS
         *  *** operações que não forem consultas devem está envolvidas em uma transação
         *  *** o objeto deve ser buscado do banco ou deve ter sido acabado de ser criado para ser removido
         */
        Pessoa pessoaRemovida = em.find(Pessoa.class, 3);
        em.getTransaction().begin();
        em.remove(pessoaRemovida);
        em.getTransaction().commit();


        em.close(); // fechando a conexão EntityManager
        emf.close(); // fechando a conexão EntityManagerFactory
        System.out.println("Fim da Aplicação");

    }

}
