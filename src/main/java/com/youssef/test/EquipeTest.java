package com.youssef.test;
import com.youssef.dao.EquipeDao;
import com.youssef.entities.Equipe;
public class EquipeTest {
public static void main(String[] args) {
//créer un objet client
Equipe c = new Equipe();
c.setNom("Youssef Benarbia");
c.setVille("Nabeul");
//ajouter l'objet client à la BD
EquipeDao cltDao = new EquipeDao();
cltDao.ajouter(c);
System.out.println("Appel de la méthode listerTous");
for (Equipe cl : cltDao.listerTous())
System.out.println(cl.getCode()+" "+cl.getNom());
System.out.println("Appel de la méthode listerParNom");
for (Equipe cl : cltDao.listerParNom("Youss"))
System.out.println(cl.getCode()+" "+cl.getNom());
//tester les autres méthodes de la classe ClientDao
}
}