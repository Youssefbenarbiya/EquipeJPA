package com.youssef.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Equipe implements Serializable{
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
//pour autoincrement
private int ID_equipe;
private String NOM_equipe;
private String rank;
public int getCode() {
return ID_equipe;
}
public void setCode(int ID_equipe) {
this.ID_equipe = ID_equipe;
}
public String getNom() {
return NOM_equipe;
}
public void setNom(String NOM_equipe) {
this.NOM_equipe = NOM_equipe;
}
public String getVille() {
return rank;
}
public void setVille(String rank) {
this.rank = rank;
}
}