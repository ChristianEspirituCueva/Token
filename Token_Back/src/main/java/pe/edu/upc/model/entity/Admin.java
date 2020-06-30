package pe.edu.upc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin")
public class Admin{
    @Id
    @Column(name="idAdmin")
    private int idAdmin;
    
    @Column(name = "Cargo",nullable = false)
    private String cargo;

    //private Long id;
    @OneToOne
    @MapsId
    private UserApp user;

    @JsonIgnore
    @OneToMany(mappedBy = "idCreator")
    private List<Bond> bonos;

    public Admin(){

    }

    public Admin(UserApp user, String cargo,int id){
        super();
        this.user=user;
        this.cargo=cargo;
        this.idAdmin=id;
    }

    public int getId(){
        return idAdmin;
    }

    public void setid(int id){
        idAdmin=id;
    }

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){
        this.cargo=cargo;
    }    
}

