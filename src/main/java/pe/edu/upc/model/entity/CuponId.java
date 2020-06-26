package pe.edu.upc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CuponId implements Serializable{
    
    private static final long serialVersionUID = 4925787537805525445L;
    
    @Column(name = "nc")    
    private int nCupon;

    private Bond idBond;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuponId)) return false;
        CuponId c = (CuponId) o;
        return Objects.equals(getId(), CuponId.getId());
    }*/
 
    @Override
    public int hashCode() {
        return (int)idBond.hashCode() + nCupon;
    }

    public CuponId(int nCupon,Bond idBond){
        this.nCupon=nCupon;
        this.idBond=idBond;
    }

    public int getNCupon(){
        return nCupon;
    }

    public void setNCupon(int nCupon){
        this.nCupon=nCupon;
    }

    public Bond getIdbond(){
        return idBond;
    }

    public void setIdBond(Bond idBond){
        this.idBond=idBond;
    }    

}