package fr.cantine.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Plat extends IndexableObject {
	private String nom;
	private float prix;
	
	@Enumerated(EnumType.STRING)//dans phyAdmin, le typePlat est par d�faut prensent par un num�ro
	private TypePlat typePlat;
	
	private String image;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public TypePlat getTypePlat() {
		return typePlat;
	}
	public void setTypePlat(TypePlat typePlat) {
		this.typePlat = typePlat;
	}
	@Override
	public String toString() {
		return "Plat [nom=" + nom + ", prix=" + prix + ", typePlat=" + typePlat + ", id" + getId() + "]";
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
