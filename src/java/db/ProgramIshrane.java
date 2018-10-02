/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
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
@Table(name = "program_ishrane")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramIshrane.findAll", query = "SELECT p FROM ProgramIshrane p")
    , @NamedQuery(name = "ProgramIshrane.findByIshId", query = "SELECT p FROM ProgramIshrane p WHERE p.ishId = :ishId")
    , @NamedQuery(name = "ProgramIshrane.findByIshkolProteina", query = "SELECT p FROM ProgramIshrane p WHERE p.ishkolProteina = :ishkolProteina")
    , @NamedQuery(name = "ProgramIshrane.findByIshkolUgljenihHidrata", query = "SELECT p FROM ProgramIshrane p WHERE p.ishkolUgljenihHidrata = :ishkolUgljenihHidrata")
    , @NamedQuery(name = "ProgramIshrane.findByIshkolMasti", query = "SELECT p FROM ProgramIshrane p WHERE p.ishkolMasti = :ishkolMasti")})
public class ProgramIshrane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ish_id")
    private Integer ishId;
    @Column(name = "ish_kolProteina")
    private Integer ishkolProteina;
    @Column(name = "ish_kolUgljenihHidrata")
    private Integer ishkolUgljenihHidrata;
    @Column(name = "ish_kolMasti")
    private Integer ishkolMasti;
    @Lob
    @Column(name = "ish_primer")
    private String ishPrimer;
    @OneToMany(mappedBy = "priId")
    private Set<ProgramVezbanjaAb0> programVezbanjaAb0Set;

    public ProgramIshrane() {
    }

    public ProgramIshrane(Integer ishId) {
        this.ishId = ishId;
    }

    public Integer getIshId() {
        return ishId;
    }

    public void setIshId(Integer ishId) {
        this.ishId = ishId;
    }

    public Integer getIshkolProteina() {
        return ishkolProteina;
    }

    public void setIshkolProteina(Integer ishkolProteina) {
        this.ishkolProteina = ishkolProteina;
    }

    public Integer getIshkolUgljenihHidrata() {
        return ishkolUgljenihHidrata;
    }

    public void setIshkolUgljenihHidrata(Integer ishkolUgljenihHidrata) {
        this.ishkolUgljenihHidrata = ishkolUgljenihHidrata;
    }

    public Integer getIshkolMasti() {
        return ishkolMasti;
    }

    public void setIshkolMasti(Integer ishkolMasti) {
        this.ishkolMasti = ishkolMasti;
    }

    public String getIshPrimer() {
        return ishPrimer;
    }

    public void setIshPrimer(String ishPrimer) {
        this.ishPrimer = ishPrimer;
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
        hash += (ishId != null ? ishId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramIshrane)) {
            return false;
        }
        ProgramIshrane other = (ProgramIshrane) object;
        if ((this.ishId == null && other.ishId != null) || (this.ishId != null && !this.ishId.equals(other.ishId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProgramIshrane[ ishId=" + ishId + " ]";
    }
    
}
