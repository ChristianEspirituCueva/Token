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
@Table(name = "cupon")
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
	private int prima;
	
	@Column(name = "vEmision")
	private float vEmision;
	
	@Column(name = "vEmisionc_escudo")
	private float vEmisionc_escudo;
	
	@Column(name = "vBonista")
	private float vBonista;
	
	@Column(name = "fechaPago")
	private Date fechaPago;
	
	@ManyToOne
	@JoinColumn(name = "idBond")
	private Bond idBond;
	
	

	public Cupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cupon(int idCupon, float vBono, float valor, float sumCECF, float escudo, int prima, float vEmision,
			float vEmisionc_escudo, float vBonista, Date fechaPago, Bond bond) {
		super();
		this.idCupon = idCupon;
		this.vBono = vBono;
		this.valor = valor;
		this.sumCECF = sumCECF;
		this.escudo = escudo;
		this.prima = prima;
		this.vEmision = vEmision;
		this.vEmisionc_escudo = vEmisionc_escudo;
		this.vBonista = vBonista;
		this.fechaPago = fechaPago;
		this.idBond = bond;
	}

	public int getIdCupon() {
		return idCupon;
	}

	public void setIdCupon(int idCupon) {
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

	public int getPrima() {
		return prima;
	}

	public void setPrima(int prima) {
		this.prima = prima;
	}

	public float getvEmision() {
		return vEmision;
	}

	public void setvEmision(float vEmision) {
		this.vEmision = vEmision;
	}

	public float getvEmisionc_escudo() {
		return vEmisionc_escudo;
	}

	public void setvEmisionc_escudo(float vEmisionc_escudo) {
		this.vEmisionc_escudo = vEmisionc_escudo;
	}

	public float getvBonista() {
		return vBonista;
	}

	public void setvBonista(float vBonista) {
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