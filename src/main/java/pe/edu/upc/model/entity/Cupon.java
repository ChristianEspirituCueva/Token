package pe.edu.upc.model.entity;

//import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cupon")
public class Cupon {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCupon;
	
	@Column(name = "vBono")
	private float vBono;
	
	@Column(name = "valor")
	private float valor;
	
	@Column(name = "sumCECF")
	private float sumCECF;
	
	@Column(name = "escudo")
	private float escudo;
	
	@Column(name = "prima")
	private float prima;
	
	@Column(name = "vEmision")
	private double vEmision;
	
	@Column(name = "vEmisionc_escudo")
	private double vEmisionc_escudo;
	
	@Column(name = "vBonista")
	private double vBonista;
	
	@Column(name = "fechaPago")
	private Date fechaPago;
	
	@ManyToOne
	@JoinColumn(name = "idBond")
	private Bond idBond;	

	public Cupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cupon(float vBono, float valor, float escudo, float prima, double vEmision,
	double vEmisionc_escudo, double vBonista, Bond bond) {
		super();
		this.vBono = vBono;
		this.valor = valor;
		//this.sumCECF = sumCECF;
		this.escudo = escudo;
		this.prima = prima;
		this.vEmision = vEmision;
		this.vEmisionc_escudo = vEmisionc_escudo;
		this.vBonista = vBonista;		
		this.idBond = bond;
	}

	public int getId() {
		return idCupon;
	}

	public void setId(int idCupon) {
		this.idCupon = idCupon;
	}

	public float getvBono() {
		return vBono;
	}

	public void setvBono(float vBono) {
		this.vBono = vBono;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getSumCECF() {
		return sumCECF;
	}

	public void setSumCECF(float sumCECF) {
		this.sumCECF = sumCECF;
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

	public double getvEmision() {
		return vEmision;
	}

	public void setvEmision(double vEmision) {
		this.vEmision = vEmision;
	}

	public double getvEmisionc_escudo() {
		return vEmisionc_escudo;
	}

	public void setvEmisionc_escudo(double vEmisionc_escudo) {
		this.vEmisionc_escudo = vEmisionc_escudo;
	}

	public double getvBonista() {
		return vBonista;
	}

	public void setvBonista(double vBonista) {
		this.vBonista = vBonista;
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