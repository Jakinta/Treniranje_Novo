/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "sadrzaj_treninga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SadrzajTreninga.findAll", query = "SELECT s FROM SadrzajTreninga s")
    , @NamedQuery(name = "SadrzajTreninga.findByTreId", query = "SELECT s FROM SadrzajTreninga s WHERE s.sadrzajTreningaPK.treId = :treId")
    , @NamedQuery(name = "SadrzajTreninga.findByVezId", query = "SELECT s FROM SadrzajTreninga s WHERE s.sadrzajTreningaPK.vezId = :vezId")
    , @NamedQuery(name = "SadrzajTreninga.findByStrTrajanje", query = "SELECT s FROM SadrzajTreninga s WHERE s.strTrajanje = :strTrajanje")
    , @NamedQuery(name = "SadrzajTreninga.findByStrbrPonavljanja", query = "SELECT s FROM SadrzajTreninga s WHERE s.strbrPonavljanja = :strbrPonavljanja")
    , @NamedQuery(name = "SadrzajTreninga.findByStrbrSerija", query = "SELECT s FROM SadrzajTreninga s WHERE s.strbrSerija = :strbrSerija")})
public class SadrzajTreninga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SadrzajTreningaPK sadrzajTreningaPK;
    @Basic(optional = false)
    @Column(name = "str_trajanje")
    private int strTrajanje;
    @Basic(optional = false)
    @Column(name = "str_brPonavljanja")
    private int strbrPonavljanja;
    @Basic(optional = false)
    @Column(name = "str_brSerija")
    private int strbrSerija;
    @JoinColumn(name = "tre_id", referencedColumnName = "tre_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Trening trening;
    @JoinColumn(name = "vez_id", referencedColumnName = "vez_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vezba vezba;

    public SadrzajTreninga() {
    }

    public SadrzajTreninga(SadrzajTreningaPK sadrzajTreningaPK) {
        this.sadrzajTreningaPK = sadrzajTreningaPK;
    }

    public SadrzajTreninga(SadrzajTreningaPK sadrzajTreningaPK, int strTrajanje, int strbrPonavljanja, int strbrSerija) {
        this.sadrzajTreningaPK = sadrzajTreningaPK;
        this.strTrajanje = strTrajanje;
        this.strbrPonavljanja = strbrPonavljanja;
        this.strbrSerija = strbrSerija;
    }

    public SadrzajTreninga(int treId, int vezId) {
        this.sadrzajTreningaPK = new SadrzajTreningaPK(treId, vezId);
    }

    public SadrzajTreningaPK getSadrzajTreningaPK() {
        return sadrzajTreningaPK;
    }

    public void setSadrzajTreningaPK(SadrzajTreningaPK sadrzajTreningaPK) {
        this.sadrzajTreningaPK = sadrzajTreningaPK;
    }

    public int getStrTrajanje() {
        return strTrajanje;
    }

    public void setStrTrajanje(int strTrajanje) {
        this.strTrajanje = strTrajanje;
    }

    public int getStrbrPonavljanja() {
        return strbrPonavljanja;
    }

    public void setStrbrPonavljanja(int strbrPonavljanja) {
        this.strbrPonavljanja = strbrPonavljanja;
    }

    public int getStrbrSerija() {
        return strbrSerija;
    }

    public void setStrbrSerija(int strbrSerija) {
        this.strbrSerija = strbrSerija;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sadrzajTreningaPK != null ? sadrzajTreningaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadrzajTreninga)) {
            return false;
        }
        SadrzajTreninga other = (SadrzajTreninga) object;
        if ((this.sadrzajTreningaPK == null && other.sadrzajTreningaPK != null) || (this.sadrzajTreningaPK != null && !this.sadrzajTreningaPK.equals(other.sadrzajTreningaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SadrzajTreninga[ sadrzajTreningaPK=" + sadrzajTreningaPK + " ]";
    }
    
}
