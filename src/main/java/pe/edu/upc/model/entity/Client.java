package pe.edu.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {

	@Id
	@Column(name = "IdUser")
	private Long idUser;
		
	@Column(name="Document",nullable = false)
	private String document;
	
	@Column(name="Ruc",nullable = false)
	private String ruc;
	
	@Column(name="Company",nullable = false)
	private String company;

	@OneToOne
	@MapsId
    private User user;
	 
	public Client(Long idUser, String document, String ruc, String company) {
		super();
		this.idUser = idUser;
		this.document = document;
		this.ruc = ruc;
		this.company = company;
	}
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
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
	 
}
