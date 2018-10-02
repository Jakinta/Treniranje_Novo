/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
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
@Table(name = "element_programa_vezbanja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ElementProgramaVezbanja.findAll", query = "SELECT e FROM ElementProgramaVezbanja e")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByPrvId", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.elementProgramaVezbanjaPK.prvId = :prvId")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByVezId", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.elementProgramaVezbanjaPK.vezId = :vezId")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByEpvTrajanje", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.epvTrajanje = :epvTrajanje")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByEpvbrSerija", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.epvbrSerija = :epvbrSerija")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByEpvbrPonavljanja", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.epvbrPonavljanja = :epvbrPonavljanja")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByEpvUcestalost", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.epvUcestalost = :epvUcestalost")
    , @NamedQuery(name = "ElementProgramaVezbanja.findByEpvNapomena", query = "SELECT e FROM ElementProgramaVezbanja e WHERE e.epvNapomena = :epvNapomena")})
public class ElementProgramaVezbanja implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ElementProgramaVezbanjaPK elementProgramaVezbanjaPK;
    @Column(name = "epv_trajanje")
    private Integer epvTrajanje;
    @Column(name = "epv_brSerija")
    private Integer epvbrSerija;
    @Column(name = "epv_brPonavljanja")
    private Integer epvbrPonavljanja;
    @Column(name = "epv_ucestalost")
    private Integer epvUcestalost;
    @Column(name = "epv_napomena")
    private String epvNapomena;
    @JoinColumn(name = "prv_id", referencedColumnName = "prv_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProgramVezbanjaAb0 programVezbanjaAb0;
    @JoinColumn(name = "vez_id", referencedColumnName = "vez_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vezba vezba;

    public ElementProgramaVezbanja() {
    }

    public ElementProgramaVezbanja(ElementProgramaVezbanjaPK elementProgramaVezbanjaPK) {
        this.elementProgramaVezbanjaPK = elementProgramaVezbanjaPK;
    }

    public ElementProgramaVezbanja(int prvId, int vezId) {
        this.elementProgramaVezbanjaPK = new ElementProgramaVezbanjaPK(prvId, vezId);
    }

    public ElementProgramaVezbanjaPK getElementProgramaVezbanjaPK() {
        return elementProgramaVezbanjaPK;
    }

    public void setElementProgramaVezbanjaPK(ElementProgramaVezbanjaPK elementProgramaVezbanjaPK) {
        this.elementProgramaVezbanjaPK = elementProgramaVezbanjaPK;
    }

    public Integer getEpvTrajanje() {
        return epvTrajanje;
    }

    public void setEpvTrajanje(Integer epvTrajanje) {
        this.epvTrajanje = epvTrajanje;
    }

    public Integer getEpvbrSerija() {
        return epvbrSerija;
    }

    public void setEpvbrSerija(Integer epvbrSerija) {
        this.epvbrSerija = epvbrSerija;
    }

    public Integer getEpvbrPonavljanja() {
        return epvbrPonavljanja;
    }

    public void setEpvbrPonavljanja(Integer epvbrPonavljanja) {
        this.epvbrPonavljanja = epvbrPonavljanja;
    }

    public Integer getEpvUcestalost() {
        return epvUcestalost;
    }

    public void setEpvUcestalost(Integer epvUcestalost) {
        this.epvUcestalost = epvUcestalost;
    }

    public String getEpvNapomena() {
        return epvNapomena;
    }

    public void setEpvNapomena(String epvNapomena) {
        this.epvNapomena = epvNapomena;
    }

    public ProgramVezbanjaAb0 getProgramVezbanjaAb0() {
        return programVezbanjaAb0;
    }

    public void setProgramVezbanjaAb0(ProgramVezbanjaAb0 programVezbanjaAb0) {
        this.programVezbanjaAb0 = programVezbanjaAb0;
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
        hash += (elementProgramaVezbanjaPK != null ? elementProgramaVezbanjaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementProgramaVezbanja)) {
            return false;
        }
        ElementProgramaVezbanja other = (ElementProgramaVezbanja) object;
        if ((this.elementProgramaVezbanjaPK == null && other.elementProgramaVezbanjaPK != null) || (this.elementProgramaVezbanjaPK != null && !this.elementProgramaVezbanjaPK.equals(other.elementProgramaVezbanjaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ElementProgramaVezbanja[ elementProgramaVezbanjaPK=" + elementProgramaVezbanjaPK + " ]";
    }
    
}
