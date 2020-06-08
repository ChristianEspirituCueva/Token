package pe.edu.upc.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Size(max = 15)
    @Column(name = "UserName",nullable = false,unique = true)
    private String userName;
    
    @Size(max = 15)
    @Column(name = "Password",nullable = false,unique = true)
    private String password;

    @Size(max = 100)
    @Column(name = "Name",nullable = false,unique = true)
    private String name;    

    @Size(max = 100)
    @Column(name = "LastName",nullable = false,unique = true)
    private String lastName;
   
    @Column(name = "Phone",nullable = false,unique = true)
    private Long phone;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private Client client;
}
