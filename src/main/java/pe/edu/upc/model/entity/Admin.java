package pe.edu.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin{
    @Id
    @Column(name="idUser")
    private int idUser;
    
    @Column(name = "Cargo")
    private int cargo;

    //private Long id;
    @OneToOne
    @MapsId
    private User user;
    
}

