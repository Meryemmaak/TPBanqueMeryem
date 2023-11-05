/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.meryy.tpbanquemery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author hp
 */
@Entity
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int solde;

    /*
     * Les méthodes suivantes sont des getters et des setters pour accéder aux propriétés de la classe.
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    /*
     * Constructeur par défaut requis par JPA pour la création d'entités depuis la base de données.
     */
    public CompteBancaire() {
    }

    /*
     * Constructeur permettant de créer un compte bancaire avec un nom et un solde initial.
     */
    public CompteBancaire(String nom, int solde) {
        this.nom = nom;
        this.solde = solde;
    }

    /*
     * Méthode pour déposer de l'argent sur le compte.
     */
    public void deposer(int montant) {
        solde += montant;
    }

    /*
     * Méthode pour retirer de l'argent du compte.
     * Si le montant à retirer est supérieur au solde, le solde est mis à zéro.
     */
    public void retirer(int montant) {
        if (montant < solde) {
            solde -= montant;
        } else {
            solde = 0;
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.meryy.tpbanquemery.entity.CompteBancaire[ id=" + id + " ]";
    }
}
