package com.nlobby.usage;

import com.nlobby.usage.domain.Member;
import com.nlobby.usage.domain.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Team real = new Team();
            real.setName("레알 마드리드");
            em.persist(real);

            Member cr7=  new Member();
            cr7.setUsername("호날두");
            cr7.setTeam(real);

            Member benzema = new Member();
            benzema.setUsername("벤제마");
            benzema.setTeam(real);

            em.persist(cr7);
            em.persist(benzema);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
