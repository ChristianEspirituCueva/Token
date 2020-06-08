package pe.edu.upc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {

	 @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int IDUSER;
	
	 @Column(name="Document",nullable = false)
	 private int Document;
	 
	 @Column(name="RUC",nullable = false)
	 private int RUC;
	 
	 @Column(name="company",nullable = false)
	 private String company;

	 
	public Client(int iDUSER, int document, int rUC, String company) {
		super();
		IDUSER = iDUSER;
		Document = document;
		RUC = rUC;
		this.company = company;
	}

	
	
	//get_and_Set
	public int getIDUSER() {
		return IDUSER;
	}

	public void setIDUSER(int iDUSER) {
		IDUSER = iDUSER;
	}

	public int getDocument() {
		return Document;
	}

	public void setDocument(int document) {
		Document = document;
	}

	public int getRUC() {
		return RUC;
	}

	public void setRUC(int rUC) {
		RUC = rUC;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	 
	 
	 
	 
	 
	 
	 
	 
}
