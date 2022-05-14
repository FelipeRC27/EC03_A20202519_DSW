package idat.edu.pe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcliente;
	private String nombre;
	private String celular;
	
	@OneToOne(mappedBy = "clientes") 
	private  Usuariocliente usuario;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "hospital_cliente",
	joinColumns = @JoinColumn(name="idcliente", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idcliente) references cliente (idcliente)")),
	inverseJoinColumns = @JoinColumn(name="idhospital", nullable = false, unique = true,
	foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (idhospital) references hospital (idhospital)")))	
	private List<Hospital> hospital=new ArrayList<>();

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Usuariocliente getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuariocliente usuario) {
		this.usuario = usuario;
	}

	public List<Hospital> getHospital() {
		return hospital;
	}

	public void setHospital(List<Hospital> hospital) {
		this.hospital = hospital;
	}

	public Cliente(Integer idcliente, String nombre, String celular, Usuariocliente usuario, List<Hospital> hospital) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.celular = celular;
		this.usuario = usuario;
		this.hospital = hospital;
	}

	public Cliente() {
		super();
	}
	
	
	
	
	
	
}
