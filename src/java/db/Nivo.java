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
@Table(name = "nivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivo.findAll", query = "SELECT n FROM Nivo n")
    , @NamedQuery(name = "Nivo.findByNivId", query = "SELECT n FROM Nivo n WHERE n.nivId = :nivId")
    , @NamedQuery(name = "Nivo.findByNivNaziv", query = "SELECT n FROM Nivo n WHERE n.nivNaziv = :nivNaziv")})
public class Nivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "niv_id")
    private Integer nivId;
    @Column(name = "niv_naziv")
    private String nivNaziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivId")
    private Set<ProgramVezbanjaAb0> programVezbanjaAb0Set;

    public Nivo() {
    }

    public Nivo(Integer nivId) {
        this.nivId = nivId;
    }

    public Integer getNivId() {
        return nivId;
    }

    public void setNivId(Integer nivId) {
        this.nivId = nivId;
    }

    public String getNivNaziv() {
        return nivNaziv;
    }

    public void setNivNaziv(String nivNaziv) {
        this.nivNaziv = nivNaziv;
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
        hash += (nivId != null ? nivId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivo)) {
            return false;
        }
        Nivo other = (Nivo) object;
        if ((this.nivId == null && other.nivId != null) || (this.nivId != null && !this.nivId.equals(other.nivId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Nivo[ nivId=" + nivId + " ]";
    }
    
}
