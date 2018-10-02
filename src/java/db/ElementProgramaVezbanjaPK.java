/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class ElementProgramaVezbanjaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "prv_id")
    private int prvId;
    @Basic(optional = false)
    @Column(name = "vez_id")
    private int vezId;

    public ElementProgramaVezbanjaPK() {
    }

    public ElementProgramaVezbanjaPK(int prvId, int vezId) {
        this.prvId = prvId;
        this.vezId = vezId;
    }

    public int getPrvId() {
        return prvId;
    }

    public void setPrvId(int prvId) {
        this.prvId = prvId;
    }

    public int getVezId() {
        return vezId;
    }

    public void setVezId(int vezId) {
        this.vezId = vezId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prvId;
        hash += (int) vezId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementProgramaVezbanjaPK)) {
            return false;
        }
        ElementProgramaVezbanjaPK other = (ElementProgramaVezbanjaPK) object;
        if (this.prvId != other.prvId) {
            return false;
        }
        if (this.vezId != other.vezId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.ElementProgramaVezbanjaPK[ prvId=" + prvId + ", vezId=" + vezId + " ]";
    }
    
}
