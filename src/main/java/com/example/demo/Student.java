package com.example.demo;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student" )
public class Student {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY) 
 @Column(name = "id")
 private Long id;

 public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



@Column(name = "cin")
 private String cin;

 @Column(name = "nom")
 private String nom;
 
 public String getCin() {
	return cin;
}

public void setCin(String cin) {
	this.cin = cin;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getNationalite() {
	return nationalite;
}

public void setNationalite(String nationalite) {
	this.nationalite = nationalite;
}

public String getDate_naiss() {
	return date_naiss;
}

public void setDate_naiss(String date_naiss) {
	this.date_naiss = date_naiss;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getTelephone() {
	return telephone;
}

public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}



public void setSituation(String situation) {
	this.situation = situation;
}

public String getAnn_etud_bac() {
	return ann_etud_bac;
}

public void setAnn_etud_bac(String ann_etud_bac) {
	this.ann_etud_bac = ann_etud_bac;
}

public String getFiliere() {
	return filiere;
}

public void setFiliere(String filiere) {
	this.filiere = filiere;
}

public String getUniversite() {
	return universite;
}

public void setUniversite(String universite) {
	this.universite = universite;
}

public String getFaculte() {
	return faculte;
}

public void setFaculte(String faculte) {
	this.faculte = faculte;
}

public String getDate_univ() {
	return date_univ;
}

public void setDate_univ(String date_univ) {
	this.date_univ = date_univ;
}

public String  getDate_licence() {
	return date_licence;
}

public void setDate_licence(String  date_licence) {
	this.date_licence = date_licence;
}

@Column(name = "activer")
private boolean activer;

public boolean isActiver() {
	return activer;
}

public void setActiver(boolean activer) {
	this.activer = activer;
}

@Column(name = "prenom")
 private String prenom;
 @Column(name = "nationalite")
 private String nationalite;
 @Column(name = "date_naiss")
 private String date_naiss;
 @Column(name = "adresse")
 private String adresse;
 @Column(name = "telephone")
 private String telephone;
 @Column(name = "Email")
 private String Email;
 @Column(name = "situation")
 private String situation;
 @Column(name = "ann_etud_bac")
 private String  ann_etud_bac;
 @Column(name = "filiere")
 private String filiere;
 @Column(name = "universite")
 private String universite;
 @Column(name = "faculte")
 private String faculte;
 @Column(name = "date_univ")
private String date_univ;

@Column(name = "note1")
	private double note1;
 @Column(name = "s1session")	
	private String s1session;



public String getS1session() {
	return s1session;
}

public void setS1session(String s1session) {
	this.s1session = s1session;
}

@Column(name = "note2")
	private double note2;	
 @Column(name = "s2session")
	private String s2session;
 	
 @Column(name = "note3")
	private double note3;	
 @Column(name = "s3session")
	private String s3session;



public double getNote2() {
	return note2;
}



public String getS2session() {
	return s2session;
}

public void setS2session(String s2session) {
	this.s2session = s2session;
}




public String getS3session() {
	return s3session;
}

public void setS3session(String s3session) {
	this.s3session = s3session;
}




public String getS4session() {
	return s4session;
}

public void setS4session(String s4session) {
	this.s4session = s4session;
}



public String getS5session() {
	return s5session;
}

public void setS5session(String s5session) {
	this.s5session = s5session;
}


public String getS6session() {
	return s6session;
}

public void setS6session(String s6session) {
	this.s6session = s6session;
}

public String getSituation() {
	return situation;
}

public void setNote(double note) {
	this.note = note;
}

@Column(name = "note4")
	private double note4;	
 @Column(name = "s4session")
	private String s4session;
 	
 @Column(name = "note5")
	private double note5;
 @Column(name = "s5session")
	private String s5session;
	
 @Column(name = "note6")
	private double note6;		
 @Column(name = "s6session")
	private String s6session;

 @Column(name = "date_licence")
	private String date_licence;

 @Column(name = "licence")
	private String licence;
 
 public void setAlicence(String alicence) {
	 licence = licence;
}

@Column(name = "note")
 private double note;

//@Override
//public int compareTo(@NotNull Student o) {
//    return Double.compare(this.getNote(), o.getNote());
// }


   // calcule de la note de dossier
 
 public double getNote() {
     double nmoy_DEUG=0, moy_DEUG = (note1+ note2 + note3 + note4) / 4;
     nmoy_DEUG = calculpts(nmoy_DEUG, moy_DEUG);

     double ptsSessionNS1=0, ptsSessionNS2=0, ptsSessionNS3=0,
            ptsSessionNS4=0, ptsSessionNS5=0, ptsSessionNS6=0,
            ptsSessionRS1=0, ptsSessionRS2=0, ptsSessionRS3=0,
            ptsSessionRS4=0, ptsSessionRS5=0, ptsSessionRS6=0;

     if ( s1session .equals("normal")) ptsSessionNS1+=0.5;
     if ( s2session.equals("normal") ) ptsSessionNS2+=0.5;
     if ( s3session.equals("normal") ) ptsSessionNS3+=0.5;
     if ( s4session.equals("normal") ) ptsSessionNS4+=0.5;
     
     
     double pts_SessionDEUG = ptsSessionNS1 + ptsSessionNS2
             + ptsSessionNS3 + ptsSessionNS4+ptsSessionRS1 + ptsSessionRS2
             + ptsSessionRS3 + ptsSessionRS4;
     
     
     if ( s5session.equals("normal") ) ptsSessionNS5+=1;
     if ( s6session.equals("normal") ) ptsSessionNS6+=1;
     
     double pts_SessionLicence = ptsSessionNS5 + ptsSessionNS6 + ptsSessionRS5 + ptsSessionRS6;

     double nMoy_Licence=0, Moy_Licence = (note5+note6) / 2;
     nMoy_Licence = calculpts(nMoy_Licence, Moy_Licence);

   
     double ptsNombreAnUniv=0, NombreAnUniv = Integer.parseInt(date_licence) - Integer.parseInt(date_univ);
     if (NombreAnUniv == 3 ) ptsNombreAnUniv+=6;
     else if (NombreAnUniv == 4 ) ptsNombreAnUniv+=3;
     return nmoy_DEUG + pts_SessionDEUG + nMoy_Licence + pts_SessionLicence + ptsNombreAnUniv ;
 }

 public double getNote1() {
	return note1;
}

public void setNote1(double note1) {
	this.note1 = note1;
}

public double getNote3() {
	return note3;
}

public void setNote3(double note3) {
	this.note3 = note3;
}

public double getNote4() {
	return note4;
}

public void setNote4(double note4) {
	this.note4 = note4;
}

public double getNote5() {
	return note5;
}

public void setNote5(double note5) {
	this.note5 = note5;
}

public double getNote6() {
	return note6;
}

public void setNote6(double note6) {
	this.note6 = note6;
}

public void setNote2(double note2) {
	this.note2 = note2;
}

private double calculpts(double y, double x) {
     if ( x >= 11 && x < 12 ) y+=2;
     else if ( x >= 12 && x < 13 ) y+=4;
     else if ( x >= 13 && x < 14 ) y+=6;
     else if (x >= 14 ) y+=8;
     return y;
 }

 @Transient
 public String getPhotosImagePath(){
     if ( licence == null  ) return null;

     return "/photos/Alicence/" + licence + "/" +licence;
 }



// public void setNote(int note) {
//     this.note = note;
// }

} 