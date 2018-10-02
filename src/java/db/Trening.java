/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "trening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trening.findAll", query = "SELECT t FROM Trening t")
    , @NamedQuery(name = "Trening.findByTreId", query = "SELECT t FROM Trening t WHERE t.treId = :treId")
    , @NamedQuery(name = "Trening.findByTreDatum", query = "SELECT t FROM Trening t WHERE t.treDatum = :treDatum")
    , @NamedQuery(name = "Trening.findByTreTrajanje", query = "SELECT t FROM Trening t WHERE t.treTrajanje = :treTrajanje")
    , @NamedQuery(name = "Trening.findByTrePuls", query = "SELECT t FROM Trening t WHERE t.trePuls = :trePuls")
    , @NamedQuery(name = "Trening.findByTreIzdrzljivost", query = "SELECT t FROM Trening t WHERE t.treIzdrzljivost = :treIzdrzljivost")})
public class Trening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tre_id")
    private Integer treId;
    @Column(name = "tre_datum")
    @Temporal(TemporalType.DATE)
    private Date treDatum;
    @Column(name = "tre_trajanje")
    private Integer treTrajanje;
    @Basic(optional = false)
    @Column(name = "tre_puls")
    private int trePuls;
    @Basic(optional = false)
    @Column(name = "tre_izdrzljivost")
    private int treIzdrzljivost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trening")
    private Set<SadrzajTreninga> sadrzajTreningaSet;
    @JoinColumn(name = "pos_id", referencedColumnName = "pos_id")
    @ManyToOne(optional = false)
    private Posetilac posId;

    public Trening() {
    }

    public Trening(Integer treId) {
        this.treId = treId;
    }

    public Trening(Integer treId, int trePuls, int treIzdrzljivost) {
        this.treId = treId;
        this.trePuls = trePuls;
        this.treIzdrzljivost = treIzdrzljivost;
    }

    public Integer getTreId() {
        return treId;
    }

    public void setTreId(Integer treId) {
        this.treId = treId;
    }

    public Date getTreDatum() {
        return treDatum;
    }

    public void setTreDatum(Date treDatum) {
        this.treDatum = treDatum;
    }

    public Integer getTreTrajanje() {
        return treTrajanje;
    }

    public void setTreTrajanje(Integer treTrajanje) {
        this.treTrajanje = treTrajanje;
    }

    public int getTrePuls() {
        return trePuls;
    }

    public void setTrePuls(int trePuls) {
        this.trePuls = trePuls;
    }

    public int getTreIzdrzljivost() {
        return treIzdrzljivost;
    }

    public void setTreIzdrzljivost(int treIzdrzljivost) {
        this.treIzdrzljivost = treIzdrzljivost;
    }

    @XmlTransient
    public Set<SadrzajTreninga> getSadrzajTreningaSet() {
        return sadrzajTreningaSet;
    }

    public void setSadrzajTreningaSet(Set<SadrzajTreninga> sadrzajTreningaSet) {
        this.sadrzajTreningaSet = sadrzajTreningaSet;
    }

    public Posetilac getPosId() {
        return posId;
    }

    public void setPosId(Posetilac posId) {
        this.posId = posId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treId != null ? treId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trening)) {
            return false;
        }
        Trening other = (Trening) object;
        if ((this.treId == null && other.treId != null) || (this.treId != null && !this.treId.equals(other.treId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Trening[ treId=" + treId + " ]";
    }
    
}
