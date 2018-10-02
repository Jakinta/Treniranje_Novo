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
@Table(name = "program_vezbanja_ab0")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramVezbanjaAb0.findAll", query = "SELECT p FROM ProgramVezbanjaAb0 p")
    , @NamedQuery(name = "ProgramVezbanjaAb0.findByPrvId", query = "SELECT p FROM ProgramVezbanjaAb0 p WHERE p.prvId = :prvId")
    , @NamedQuery(name = "ProgramVezbanjaAb0.findByPrvkrvnaGrupa", query = "SELECT p FROM ProgramVezbanjaAb0 p WHERE p.prvkrvnaGrupa = :prvkrvnaGrupa")
    , @NamedQuery(name = "ProgramVezbanjaAb0.findByPrvNapomena", query = "SELECT p FROM ProgramVezbanjaAb0 p WHERE p.prvNapomena = :prvNapomena")})
public class ProgramVezbanjaAb0 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prv_id")
    private Integer prvId;
    @Column(name = "prv_krvnaGrupa")
    private String prvkrvnaGrupa;
    @Column(name = "prv_napomena")
    private String prvNapomena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programVezbanjaAb0")
    private Set<ElementProgramaVezbanja> elementProgramaVezbanjaSet;
    @OneToMany(mappedBy = "prvId")
    private Set<Posetilac> posetilacSet;
    @JoinColumn(name = "clj_id", referencedColumnName = "clj_id")
    @ManyToOne(optional = false)
    private Cilj cljId;
    @JoinColumn(name = "niv_id", referencedColumnName = "niv_id")
    @ManyToOne(optional = false)
    private Nivo nivId;
    @JoinColumn(name = "pri_id", referencedColumnName = "ish_id")
    @ManyToOne
    private ProgramIshrane priId;

    public ProgramVezbanjaAb0() {
    }

    public ProgramVezbanjaAb0(Integer prvId) {
        this.prvId = prvId;
    }

    public Integer getPrvId() {
        return prvId;
    }

    public void setPrvId(Integer prvId) {
        this.prvId = prvId;
    }

    public String getPrvkrvnaGrupa() {
        return prvkrvnaGrupa;
    }

    public void setPrvkrvnaGrupa(String prvkrvnaGrupa) {
        this.prvkrvnaGrupa = prvkrvnaGrupa;
    }

    public String getPrvNapomena() {
        return prvNapomena;
    }

    public void setPrvNapomena(String prvNapomena) {
        this.prvNapomena = prvNapomena;
    }

    @XmlTransient
    public Set<ElementProgramaVezbanja> getElementProgramaVezbanjaSet() {
        return elementProgramaVezbanjaSet;
    }

    public void setElementProgramaVezbanjaSet(Set<ElementProgramaVezbanja> elementProgramaVezbanjaSet) {
        this.elementProgramaVezbanjaSet = elementProgramaVezbanjaSet;
    }

    @XmlTransient
    public Set<Posetilac> getPosetilacSet() {
        return posetilacSet;
    }

    public void setPosetilacSet(Set<Posetilac> posetilacSet) {
        this.posetilacSet = posetilacSet;
    }

    public Cilj getCljId() {
        return cljId;
    }

    public void setCljId(Cilj cljId) {
        this.cljId = cljId;
    }

    public Nivo getNivId() {
        return nivId;
    }

    public void setNivId(Nivo nivId) {
        this.nivId = nivId;
    }

    public ProgramIshrane getPriId() {
        return priId;
    }

    public void setPriId(ProgramIshrane priId) {
        this.priId = priId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prvId != null ? prvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramVezbanjaAb0)) {
            return false;
        }
        ProgramVezbanjaAb0 other = (ProgramVezbanjaAb0) object;
        if ((this.prvId == null && other.prvId != null) || (this.prvId != null && !this.prvId.equals(other.prvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ProgramVezbanjaAb0[ prvId=" + prvId + " ]";
    }
    
}
