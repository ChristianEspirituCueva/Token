package pe.edu.upc.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Bond")
public class Bond{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBond;

    @ManyToOne
    @JoinColumn(name="idAdmin")
    private Admin idCreator;

    @Column(name="VNominal",nullable = false)
    private float vNominal;

    @Column(name="VComercial",nullable = false)
    private float vComercial;

    //@Min(0)
    @Column(name="Time",nullable = false)
    private Integer time;

    @Column(name="Tea",nullable = false)
    private float tea;

    @Column(name="PPrima",nullable = false)
    private float pPrima;

    @Column(name="PEstruc",nullable = false)
    private float pEstruc;

    @Column(name="PFlot",nullable = false)
    private float pFlot;

    @Column(name="PCavali",nullable = false)
    private float pCavali;

    @Column(name="Frequency",nullable = false,length = 100)
    private String frequency;

    @Column(name="Method",nullable = false,length = 100)
    private String method;

    @Column(name="FecEmision",nullable = false)
    private Date fecEmision;

    @Column(name="FecLiqu",nullable = false)
    private Date fecLiqu;

    @Column(name="TceaEscudo",nullable = false)
    private float tceaEscudo;

    @Column(name="Tcea",nullable = false)
    private float tcea;

    @Column(name="TreaBonista",nullable = false)
    private float treaBonista;

    @Column(name="Estado",nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="idClient")
	private Client idclient;

    @Column(name="TypeMoney",nullable = false,length = 100)
	private String typeMoney;
	
	@OneToMany(mappedBy = "idBond")
	private List<Cupon> cupons;

    public Integer getId() {
		return idBond;
	}

	public void setId(Integer idBond) {
		this.idBond = idBond;
	}

	public float getvNominal() {
		return vNominal;
	}

	public void setvNominal(float vNominal) {
		this.vNominal = vNominal;
	}

	public float getvComercial() {
		return vComercial;
	}

	public void setvComercial(float vComercial) {
		this.vComercial = vComercial;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public float getTea() {
		return tea;
	}

	public void setTea(float tea) {
		this.tea = tea;
	}

	public float getpPrima() {
		return pPrima;
	}

	public void setpPrima(float pPrima) {
		this.pPrima = pPrima;
	}

	public float getpEstruc() {
		return pEstruc;
	}

	public void setpEstruc(float pEstruc) {
		this.pEstruc = pEstruc;
	}

	public float getpFlot() {
		return pFlot;
	}

	public void setpFlot(float pFlot) {
		this.pFlot = pFlot;
	}

	public float getpCavali() {
		return pCavali;
	}

	public void setpCavali(float pCavali) {
		this.pCavali = pCavali;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Date getFecEmision() {
		return fecEmision;
	}

	public void setFecEmision(Date fecEmision) {
		this.fecEmision = fecEmision;
	}

	public Date getFecLiqu() {
		return fecLiqu;
	}

	public void setFecLiqu(Date fecLiqu) {
		this.fecLiqu = fecLiqu;
	}

	public float getTceaEscudo() {
		return tceaEscudo;
	}

	public void setTceaEscudo(float tceaEscudo) {
		this.tceaEscudo = tceaEscudo;
	}

	public float getTcea() {
		return tcea;
	}

	public void setTcea(float tcea) {
		this.tcea = tcea;
	}

	public float getTreaBonista() {
		return treaBonista;
	}

	public void setTreaBonista(float treaBonista) {
		this.treaBonista = treaBonista;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTypeMoney() {
		return typeMoney;
	}

	public void setTypeMoney(String typeMoney) {
		this.typeMoney = typeMoney;
	}

	public Admin getIdCreator(){
		return idCreator;
	}

	public void setIdCreator(Admin admin){
		idCreator=admin;
	}

	public Client getIdClient(){
		return idclient;
	}

	public void setIdClient(Client client){
		idclient=client;
	}

	public List<Cupon> getCupons(){
		return cupons;
	}

	public void setCupons(List<Cupon> cupons){
		this.cupons=cupons;
	}
}