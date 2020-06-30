package pe.edu.upc.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Client")
public class Client {

	@Id
	@Column(name = "IdClient")
	private int idClient;
		
	@Column(name="Document",nullable = false)
	private String document;
	
	@Column(name="Ruc",nullable = false)
	private String ruc;
	
	@Column(name="Company",nullable = false)
	private String company;

	@OneToOne
	@MapsId
	private UserApp user;
	
	@JsonIgnore
	@OneToMany(mappedBy = "idClient")
	private List<Bond> bonos;

	public Client(){

	}

	public Client(UserApp user,String documento,String ruc,String company,int id){
		super();
		this.user=user;
		this.document=documento;
		this.ruc=ruc;
		this.company=company;
		this.idClient=id;
	}
	
	public int getId() {
		return idClient;
	}

	public void setId(int idClient) {
		this.idClient = idClient;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getRUC() {
		return ruc;
	}

	public void setRUC(String ruc) {
		this.ruc = ruc;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Bond> getbonds(){
		return bonos;
	}

	public void setbonds(List<Bond> bonos){
		this.bonos=bonos;
	}
	 
}
