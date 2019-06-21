/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author MikoPC
 */
@Embeddable
public class InterventionItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "itemID")
    private String itemID;
    @Basic(optional = false)
    @Column(name = "interventionID")
    private String interventionID;

    public InterventionItemPK() {
    }

    public InterventionItemPK(String itemID, String interventionID) {
        this.itemID = itemID;
        this.interventionID = interventionID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getInterventionID() {
        return interventionID;
    }

    public void setInterventionID(String interventionID) {
        this.interventionID = interventionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        hash += (interventionID != null ? interventionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterventionItemPK)) {
            return false;
        }
        InterventionItemPK other = (InterventionItemPK) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        if ((this.interventionID == null && other.interventionID != null) || (this.interventionID != null && !this.interventionID.equals(other.interventionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "controller.InterventionItemPK[ itemID=" + itemID + ", interventionID=" + interventionID + " ]";
    }
    
}
