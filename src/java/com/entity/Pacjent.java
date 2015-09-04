/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a
 */
@Entity
@Table(name = "Pacjent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacjent.findAll", query = "SELECT p FROM Pacjent p"),
    @NamedQuery(name = "Pacjent.findById", query = "SELECT p FROM Pacjent p WHERE p.id = :id"),
    @NamedQuery(name = "Pacjent.findByImie", query = "SELECT p FROM Pacjent p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pacjent.findByNazwisko", query = "SELECT p FROM Pacjent p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Pacjent.findByPesel", query = "SELECT p FROM Pacjent p WHERE p.pesel = :pesel"),
    @NamedQuery(name = "Pacjent.findByDataUr", query = "SELECT p FROM Pacjent p WHERE p.dataUr = :dataUr"),
    @NamedQuery(name = "Pacjent.findByAdres", query = "SELECT p FROM Pacjent p WHERE p.adres = :adres"),
    @NamedQuery(name = "Pacjent.findByTel", query = "SELECT p FROM Pacjent p WHERE p.tel = :tel"),
    @NamedQuery(name = "Pacjent.findByWaga", query = "SELECT p FROM Pacjent p WHERE p.waga = :waga"),
    @NamedQuery(name = "Pacjent.findByWzrost", query = "SELECT p FROM Pacjent p WHERE p.wzrost = :wzrost")})
public class Pacjent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "pesel", unique = true)
    private String pesel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_ur")
    @Temporal(TemporalType.DATE)
    private Date dataUr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "adres")
    private String adres;
    @Size(max = 9)
    @Column(name = "tel")
    private String tel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "waga")
    private Float waga;
    @Column(name = "wzrost")
    private Integer wzrost;

    public Pacjent() {
    }

    public Pacjent(Integer id) {
        this.id = id;
    }

    public Pacjent(Integer id, String imie, String nazwisko, String pesel, Date dataUr, String adres) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUr = dataUr;
        this.adres = adres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getDataUr() {
        return dataUr;
    }

    public void setDataUr(Date dataUr) {
        this.dataUr = dataUr;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Float getWaga() {
        return waga;
    }

    public void setWaga(Float waga) {
        this.waga = waga;
    }

    public Integer getWzrost() {
        return wzrost;
    }

    public void setWzrost(Integer wzrost) {
        this.wzrost = wzrost;
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
        if (!(object instanceof Pacjent)) {
            return false;
        }
        Pacjent other = (Pacjent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Pacjent[ id=" + id + " ]";
    }
    
}
