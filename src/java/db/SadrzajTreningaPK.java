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
public class SadrzajTreningaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tre_id")
    private int treId;
    @Basic(optional = false)
    @Column(name = "vez_id")
    private int vezId;

    public SadrzajTreningaPK() {
    }

    public SadrzajTreningaPK(int treId, int vezId) {
        this.treId = treId;
        this.vezId = vezId;
    }

    public int getTreId() {
        return treId;
    }

    public void setTreId(int treId) {
        this.treId = treId;
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
        hash += (int) treId;
        hash += (int) vezId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SadrzajTreningaPK)) {
            return false;
        }
        SadrzajTreningaPK other = (SadrzajTreningaPK) object;
        if (this.treId != other.treId) {
            return false;
        }
        if (this.vezId != other.vezId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.SadrzajTreningaPK[ treId=" + treId + ", vezId=" + vezId + " ]";
    }
    
}
