package com.youssef.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.youssef.entities.Equipe;
import com.youssef.util.JPAutil;

public class EquipeDao {

    private EntityManager entityManager = JPAutil.getEntityManager("MonProjetJPA");

    public void ajouter(Equipe c) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(c);
        tx.commit();
    }

    public void modifier(Equipe c) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(c);
        tx.commit();
    }

    public void supprimer(Equipe c) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        c = entityManager.merge(c);
        entityManager.remove(c);
        tx.commit();
    }

    public Equipe consulter(Equipe c, Object id) {
        return entityManager.find(c.getClass(), id);
    }

    public List<Equipe> listerTous() {
        List<Equipe> equipes = entityManager.createQuery("select c from Equipe c", Equipe.class).getResultList();
        return equipes;
    }

    public List<Equipe> listerParNom(String nom) {
        List<Equipe> equipes = entityManager.createQuery(
                "select c from Equipe c where c.NOM_equipe like :pnom", Equipe.class)
                .setParameter("pnom", "%" + nom + "%")
                .getResultList();
        return equipes;
    }

}
