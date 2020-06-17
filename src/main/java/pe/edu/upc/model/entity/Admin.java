package pe.edu.upc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin{
    @Id
    @Column(name="idAdmin")
    private Integer idAdmin;
    
    @Column(name = "Cargo",nullable = false)
    private String cargo;

    //private Long id;
    @OneToOne
    @MapsId
    private UserApp user;

    @OneToMany(mappedBy = "idCreator")
    private List<Bond> bonos;

    public Integer getId(){
        return idAdmin;
    }

    public void setid(Integer id){
        idAdmin=id;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo=cargo;
    }    
}

