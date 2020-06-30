package pe.edu.upc.model.entity;

import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
//import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cupon")
public class Cupon {

	//@EmbeddedId
	//private CuponId id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nc",nullable = false)
    private int nCupon;

	//@MapsId("idBond")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name ="idBond", referencedColumnName = "idBond")		
	private Bond idBond;

    //@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int idCupon;

	@Column(name = "Pg",nullable = false)
	private String pg;
	
	@Column(name = "Bono",nullable = false)
	private float bono;
	
	@Column(name = "BonoInd",nullable = false)
	private float bonoInd;
	
	@Column(name = "Interes",nullable = false)
	private float interes;

	@Column(name = "Cuota",nullable = false)
	private double cuota;

	@Column(name = "Amort",nullable = false)
	private double amort;

	@Column(name = "Prima",nullable = false)
	private float prima;
	
	@Column(name = "Escudo",nullable = false)
	private float escudo;
	
	@Column(name = "FlujoE",nullable = false)
	private double flujoE;//flujo del emisor
	
	@Column(name = "FlujoEcE",nullable = false)
	private double flujoEcE;//flujo del emifor con escudo

	@Column(name = "FlujoB",nullable = false)
	private double flujoB;//flujo del bonista
	
	@Column(name = "fechaPago",nullable = true)
	private Date fechaPago;	

	public Cupon() {
		super();		
	}

	public Cupon(String pg,float bono, float bonoInd, float interes, double cuota, double amort, float prima,float escudo,
	double flujoE, double flujoEcE, double flujoB, int ncupon, Bond idbond) {		
		this.pg= pg;
		this.bono = bono;
		this.bonoInd = bonoInd;
		this.interes = interes;
		this.cuota = escudo;
		this.amort = prima;
		this.prima = prima;
		this.escudo = escudo;
		this.flujoE = flujoE;		
		this.flujoEcE = flujoEcE;
		this.flujoB = flujoB;
		this.fechaPago=null;
		this.nCupon= ncupon;
		this.idBond= idbond;
	}

	public int getId() {
		return id;
	}

	public void setId(int idCupon) {
		this.id = idCupon;
	}

	public int getNCupon(){
		return nCupon;
	}

	public void setNCupon(int nCupon){
		this.nCupon=nCupon;
	}

	public float getBono() {
		return bono;
	}

	public void setBono(float bono) {
		this.bono = bono;
	}

	public float getBonoInd() {
		return bonoInd;
	}

	public void setBonoInd(float bonoInd) {
		this.bonoInd = bonoInd;
	}

	public float getInteres() {
		return interes;
	}

	public void setInteres(float interes) {
		this.interes = interes;
	}

	public float getEscudo() {
		return escudo;
	}

	public void setEscudo(float escudo) {
		this.escudo = escudo;
	}

	public float getPrima() {
		return prima;
	}

	public void setPrima(float prima) {
		this.prima = prima;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}

	public double getAmort() {
		return amort;
	}

	public void setAmort(double amort) {
		this.amort = amort;
	}


	public double getFlujoE() {
		return flujoE;
	}

	public void setFlujoE(double flujoE) {
		this.flujoE = flujoE;
	}

	public double getFlujoEcE() {
		return flujoEcE;
	}

	public void setFlujoEcE(double vEmisionc_escudo) {
		this.flujoEcE = vEmisionc_escudo;
	}

	public double getFlujoB() {
		return flujoB;
	}

	public void setFlujoB(double flujoB) {
		this.flujoB = flujoB;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Bond getBond() {
		return idBond;
	}

	public void setBond(Bond bond) {
		this.idBond = bond;
	}
    
}