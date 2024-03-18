package com.youssef.test;

import com.youssef.dao.EquipeDao;
import com.youssef.entities.Equipe;

public class EquipeTest {
    public static void main(String[] args) {
        // créer un objet equipe 1
        Equipe equipe1 = new Equipe();
        equipe1.setNom("fc Bercelone");
        equipe1.setRank("3");

        // créer un objet equipe 2
        Equipe equipe2 = new Equipe();
        equipe2.setNom("Paris saint germin");
        equipe2.setRank("1");

        
        // ajouter les équipes à la BD
        EquipeDao equipeDao = new EquipeDao();
        equipeDao.ajouter(equipe1);
        equipeDao.ajouter(equipe2);

        // Afficher les équipes avant modification
        System.out.println("Appel de la méthode listerTous avant modification :");
        for (Equipe equipe : equipeDao.listerTous())
            System.out.println(equipe.getCode() + " " + equipe.getNom());

        // Modifier l'équipe 1
        equipe1.setNom("Real madrid");
        equipeDao.modifier(equipe1);

        // Afficher les équipes après modification de l'équipe 1
        System.out.println("Appel de la méthode listerTous après modification :");
        for (Equipe equipe : equipeDao.listerTous())
            System.out.println(equipe.getCode() + " " + equipe.getNom());

        // Supprimer l'équipe 2
        equipeDao.supprimer(equipe2);

        // Afficher les équipes après suppression de l'équipe 2
        System.out.println("Appel de la méthode listerTous après suppression :");
        for (Equipe equipe : equipeDao.listerTous())
            System.out.println(equipe.getCode() + " " + equipe.getNom());
        
        
        Equipe equipeConsulter = equipeDao.consulter(new Equipe(), 13); 
        //System.out.println("Equipe consultée : " + equipeConsulter.getCode() + " " + equipeConsulter.getNom());
        if (equipeConsulter == null) {
        	System.out.println("equipe not found");
        }
        else {
            equipeDao.supprimer(equipeConsulter);

        }
        //equipeConsulter.setRank("10"); 

       
    }
}
