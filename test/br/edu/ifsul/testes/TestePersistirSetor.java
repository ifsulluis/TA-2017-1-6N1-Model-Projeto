package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorge
 */
public class TestePersistirSetor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirSetor() {
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
    public void teste(){
        boolean exception = false;
        try {
            Servico s = new Servico();
            s.setNome("Adminstrativo");
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }
    
    
    
    
}
