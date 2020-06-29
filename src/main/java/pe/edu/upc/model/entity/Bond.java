package pe.edu.upc.model.entity;

import java.util.Date;
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
    private int idBond;

    @ManyToOne
    @JoinColumn(name="idAdmin",nullable = false)
    private Admin idCreator;

    @Column(name="VNominal",nullable = false)
    private float vNominal;

    @Column(name="VComercial",nullable = false)
	private float vComercial;
	
    @Column(name="nYears",nullable = false)
    private int nYears;
	
	//dias por periodo
	@Column(name="dxp",nullable = false)
	private int dxp;

	//días por año
	@Column(name="dxa",nullable=false)
	private int dxa;

	//imp.Renta
	@Column(name="impRenta",nullable=false)
	private float impRenta;

	//pcolocacion
	@Column(name="pCol",nullable=true)
	private float pCol;

	//inflación esperada: preguntar
	
	// tasa de descuento: preguntar
	@Column(name="TDes",nullable=false)	
	private float tDes;

    @Column(name="Tea",nullable = false)
    private float tea;

    @Column(name="PPrima",nullable = false)
    private float pPrima;

    @Column(name="PEstruc",nullable = true)
    private float pEstruc;

    @Column(name="PFlot",nullable = true)
    private float pFlot;

    @Column(name="PCavali",nullable = true)
    private float pCavali;    

    @Column(name="Method",nullable = false,length = 100)
    private String method;

    @Column(name="FecEmision",nullable = true)
    private Date fecEmision;

    @Column(name="FecLiqu",nullable = true)
    private Date fecLiqu;

    @Column(name="TceaEscudo",nullable = true)
    private double tceaEscudo;

    @Column(name="Tcea",nullable = true)
    private double tcea;

    @Column(name="TreaBonista",nullable = true)
	private double treaBonista;
	
	@Column(name="CPrice",nullable=true)
	private double cPrice;

	@Column(name="Vna",nullable=true)
	private double vna;

    @Column(name="Estado",nullable = false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(name="idClient",nullable = true)
	private Client idClient;

    @Column(name="TypeMoney",nullable = false)
	private String typeMoney;
	
	@OneToMany(mappedBy = "idBond")
	private List<Cupon> cupons;

	public Bond(){
		super();
	}

	public Bond(Admin admin,float vNominal,float vComerial,int nYears, int dxp,int dxa,float impRenta, float pCol, float tDes, float tea,float pPrima, float pEstruc, float pFlot, float pCavali, String method, boolean estado, String Money){
		this.idCreator=admin;
		this.vNominal=vNominal;
		this.vComercial = vComerial;
		this.nYears=nYears;
		this.dxp=dxp;
		this.dxa=dxa;
		this.impRenta=impRenta;
		this.pCol=pCol;
		this.pPrima=pPrima;
		this.pFlot=pFlot;
		this.pEstruc=pEstruc;
		this.pCavali=pCavali;
		this.tea=tea;
		this.tDes=tDes;
		this.method=method;
		this.estado=estado;
		this.typeMoney=Money;
	}

    public int getId() {
		return idBond;
	}

	public void setId(int idBond) {
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

	public int getNYears() {
		return nYears;
	}

	public void setNYears(int nYears) {
		this.nYears = nYears;
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

	public int getDxp() {
		return dxp;
	}

	public void setDxp(int dxp) {
		this.dxp = dxp;
	}

	public int getDxA(){
		return dxa;
	}

	public void setDxA(int dxa){
		this.dxa=dxa;
	}

	public float getImpRenta(){
		return impRenta;
	}

	public void setImpRenta(float impRenta){
		this.impRenta=impRenta;
	}

	public float getTDes(){
		return tDes;
	}

	public void setTDes(float tDes){
		this.tDes=tDes;
	}

	public float getPCol(){
		return pCol;
	}

	public void setPCol(float pCol){
		this.pCol=pCol;
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

	public double getTceaEscudo() {
		return tceaEscudo;
	}

	public void setTceaEscudo(double tceaEscudo) {
		this.tceaEscudo = tceaEscudo;
	}

	public double getTcea() {
		return tcea;
	}

	public void setTcea(double tcea) {
		this.tcea = tcea;
	}

	public double getTreaBonista() {
		return treaBonista;
	}

	public void setTreaBonista(double treaBonista) {
		this.treaBonista = treaBonista;
	}

	public double getCPrice(){
		return cPrice;
	}

	public void setCPrice(double cPrice){
		this.cPrice=cPrice;
	}

	public double getVna(){
		return vna;
	}

	public void setVna(double vna){
		this.vna=vna;
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
		return idClient;
	}

	public void setIdClient(Client client){
		idClient=client;
	}

	public List<Cupon> getCupons(){
		return cupons;
	}

	public void setCupons(List<Cupon> cupons){
		this.cupons=cupons;
	}
}