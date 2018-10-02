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
@Table(name = "cilj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cilj.findAll", query = "SELECT c FROM Cilj c")
    , @NamedQuery(name = "Cilj.findByCljId", query = "SELECT c FROM Cilj c WHERE c.cljId = :cljId")
    , @NamedQuery(name = "Cilj.findByCljNaziv", query = "SELECT c FROM Cilj c WHERE c.cljNaziv = :cljNaziv")})
public class Cilj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clj_id")
    private Integer cljId;
    @Column(name = "clj_naziv")
    private String cljNaziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cljId")
    private Set<ProgramVezbanjaAb0> programVezbanjaAb0Set;

    public Cilj() {
    }

    public Cilj(Integer cljId) {
        this.cljId = cljId;
    }

    public Integer getCljId() {
        return cljId;
    }

    public void setCljId(Integer cljId) {
        this.cljId = cljId;
    }

    public String getCljNaziv() {
        return cljNaziv;
    }

    public void setCljNaziv(String cljNaziv) {
        this.cljNaziv = cljNaziv;
    }

    @XmlTransient
    public Set<ProgramVezbanjaAb0> getProgramVezbanjaAb0Set() {
        return programVezbanjaAb0Set;
    }

    public void setProgramVezbanjaAb0Set(Set<ProgramVezbanjaAb0> programVezbanjaAb0Set) {
        this.programVezbanjaAb0Set = programVezbanjaAb0Set;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cljId != null ? cljId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cilj)) {
            return false;
        }
        Cilj other = (Cilj) object;
        if ((this.cljId == null && other.cljId != null) || (this.cljId != null && !this.cljId.equals(other.cljId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Cilj[ cljId=" + cljId + " ]";
    }
    
}
