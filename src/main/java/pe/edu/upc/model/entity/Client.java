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
@Table(name="Client")
public class Client {

	@Id
	@Column(name = "IdUser")
	private Integer idUser;
		
	@Column(name="Document",nullable = false)
	private String document;
	
	@Column(name="Ruc",nullable = false)
	private String ruc;
	
	@Column(name="Company",nullable = false)
	private String company;

	@OneToOne
	@MapsId
	private User user;
	
	@OneToMany(mappedBy = "idclient")
	private List<Bond> bonos;	
	
	public Integer getId() {
		return idUser;
	}

	public void setId(Integer idUser) {
		this.idUser = idUser;
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
