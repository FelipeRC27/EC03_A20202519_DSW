package idat.edu.pe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "hospital")
@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idhospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	@ManyToMany(mappedBy = "hospital", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cliente> clientes = new ArrayList<>();

	public Integer getIdhospital() {
		return idhospital;
	}

	public void setIdhospital(Integer idhospital) {
		this.idhospital = idhospital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Hospital(Integer idhospital, String nombre, String descripcion, String distrito, List<Cliente> clientes) {
		super();
		this.idhospital = idhospital;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distrito = distrito;
		this.clientes = clientes;
	}

	public Hospital() {
		super();
	}
	
	
	

}
