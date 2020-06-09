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
    private Integer id;

    @Size(max = 15)
    @Column(name = "Username",nullable = false,unique = true)
    private String username;
    
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
    private Admin admin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)    
    private Client client;

    public Integer getId(){
        return id;
    }

    public void setid(Integer id){
        this.id=id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public long getPhone(){
        return phone;
    }

    public void setPhone(long phone){
        this.phone=phone;
    }
}
