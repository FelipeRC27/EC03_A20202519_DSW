package idat.edu.pe.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "usuariocliente")
@Entity
public class Usuariocliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusuario;
	private String usuario;
	private String password;
	private String rol;
	
	@OneToOne
	@JoinColumn(name = "idcliente", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idcliente) references cliente (idcliente)"))
	private Cliente clientes;

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Usuariocliente(Integer idusuario, String usuario, String password, String rol, Cliente clientes) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.clientes = clientes;
	}

	public Usuariocliente() {
		super();
	}

	
	
	
}
