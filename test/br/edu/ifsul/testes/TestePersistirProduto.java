package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirProduto {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirProduto() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-2017-1-6N1-ModelPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Produto p1 = new Produto();
            p1.setNome("Ração");
            p1.setDescricao("Ração para cachorros");
            p1.setPreco(12.99);
            Produto p2 = new Produto();
            p2.setNome("Roupas Pet");
            p2.setDescricao("Roupas de tecido para cachorro e gatos");
            p2.setPreco(30.00);
            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
