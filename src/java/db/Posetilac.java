/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "posetilac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posetilac.findAll", query = "SELECT p FROM Posetilac p")
    , @NamedQuery(name = "Posetilac.findByPosId", query = "SELECT p FROM Posetilac p WHERE p.posId = :posId")
    , @NamedQuery(name = "Posetilac.findByPosIme", query = "SELECT p FROM Posetilac p WHERE p.posIme = :posIme")
    , @NamedQuery(name = "Posetilac.findByPosPrezime", query = "SELECT p FROM Posetilac p WHERE p.posPrezime = :posPrezime")
    , @NamedQuery(name = "Posetilac.findByPosEmail", query = "SELECT p FROM Posetilac p WHERE p.posEmail = :posEmail")
    , @NamedQuery(name = "Posetilac.findByPosPassword", query = "SELECT p FROM Posetilac p WHERE p.posPassword = :posPassword")})
public class Posetilac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pos_id")
    private Integer posId;
    @Column(name = "pos_ime")
    private String posIme;
    @Column(name = "pos_prezime")
    private String posPrezime;
    @Column(name = "pos_email")
    private String posEmail;
    @Column(name = "pos_password")
    private String posPassword;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id")
    @ManyToOne
    private ProgramVezbanjaAb0 prvId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "posId")
    private Set<Trening> treningSet;

    public Posetilac() {
    }

    public Posetilac(Integer posId) {
        this.posId = posId;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getPosIme() {
        return posIme;
    }

    public void setPosIme(String posIme) {
        this.posIme = posIme;
    }

    public String getPosPrezime() {
        return posPrezime;
    }

    public void setPosPrezime(String posPrezime) {
        this.posPrezime = posPrezime;
    }

    public String getPosEmail() {
        return posEmail;
    }

    public void setPosEmail(String posEmail) {
        this.posEmail = posEmail;
    }

    public String getPosPassword() {
        return posPassword;
    }

    public void setPosPassword(String posPassword) {
        this.posPassword = posPassword;
    }

    public ProgramVezbanjaAb0 getPrvId() {
        return prvId;
    }

    public void setPrvId(ProgramVezbanjaAb0 prvId) {
        this.prvId = prvId;
    }

    @XmlTransient
    public Set<Trening> getTreningSet() {
        return treningSet;
    }

    public void setTreningSet(Set<Trening> treningSet) {
        this.treningSet = treningSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (posId != null ? posId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posetilac)) {
            return false;
        }
        Posetilac other = (Posetilac) object;
        if ((this.posId == null && other.posId != null) || (this.posId != null && !this.posId.equals(other.posId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Posetilac[ posId=" + posId + " ]";
    }
    
}
