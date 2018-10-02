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
import javax.persistence.Lob;
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
@Table(name = "vezba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vezba.findAll", query = "SELECT v FROM Vezba v")
    , @NamedQuery(name = "Vezba.findByVezId", query = "SELECT v FROM Vezba v WHERE v.vezId = :vezId")
    , @NamedQuery(name = "Vezba.findByVezNaziv", query = "SELECT v FROM Vezba v WHERE v.vezNaziv = :vezNaziv")
    , @NamedQuery(name = "Vezba.findByVezAnaerobna", query = "SELECT v FROM Vezba v WHERE v.vezAnaerobna = :vezAnaerobna")
    , @NamedQuery(name = "Vezba.findByVezSlika", query = "SELECT v FROM Vezba v WHERE v.vezSlika = :vezSlika")})
public class Vezba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vez_id")
    private Integer vezId;
    @Column(name = "vez_naziv")
    private String vezNaziv;
    @Column(name = "vez_anaerobna")
    private Integer vezAnaerobna;
    @Lob
    @Column(name = "vez_opis")
    private String vezOpis;
    @Column(name = "vez_slika")
    private String vezSlika;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vezba")
    private Set<ElementProgramaVezbanja> elementProgramaVezbanjaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vezba")
    private Set<SadrzajTreninga> sadrzajTreningaSet;

    public Vezba() {
    }

    public Vezba(Integer vezId) {
        this.vezId = vezId;
    }

    public Integer getVezId() {
        return vezId;
    }

    public void setVezId(Integer vezId) {
        this.vezId = vezId;
    }

    public String getVezNaziv() {
        return vezNaziv;
    }

    public void setVezNaziv(String vezNaziv) {
        this.vezNaziv = vezNaziv;
    }

    public Integer getVezAnaerobna() {
        return vezAnaerobna;
    }

    public void setVezAnaerobna(Integer vezAnaerobna) {
        this.vezAnaerobna = vezAnaerobna;
    }

    public String getVezOpis() {
        return vezOpis;
    }

    public void setVezOpis(String vezOpis) {
        this.vezOpis = vezOpis;
    }

    public String getVezSlika() {
        return vezSlika;
    }

    public void setVezSlika(String vezSlika) {
        this.vezSlika = vezSlika;
    }

    @XmlTransient
    public Set<ElementProgramaVezbanja> getElementProgramaVezbanjaSet() {
        return elementProgramaVezbanjaSet;
    }

    public void setElementProgramaVezbanjaSet(Set<ElementProgramaVezbanja> elementProgramaVezbanjaSet) {
        this.elementProgramaVezbanjaSet = elementProgramaVezbanjaSet;
    }

    @XmlTransient
    public Set<SadrzajTreninga> getSadrzajTreningaSet() {
        return sadrzajTreningaSet;
    }

    public void setSadrzajTreningaSet(Set<SadrzajTreninga> sadrzajTreningaSet) {
        this.sadrzajTreningaSet = sadrzajTreningaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vezId != null ? vezId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vezba)) {
            return false;
        }
        Vezba other = (Vezba) object;
        if ((this.vezId == null && other.vezId != null) || (this.vezId != null && !this.vezId.equals(other.vezId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Vezba[ vezId=" + vezId + " ]";
    }
    
}
