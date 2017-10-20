package modelo;

import java.util.Date;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String dni;
	private String domicilio;
	private Date fechaNacimiento;
	private String mail;
	private List<Producto> carroCompra;
	
	public Usuario(String nombre, String dni, String domicilio, Date fechaNacimiento, String mail) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
		this.mail = mail;
		this.carroCompra = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Producto> getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(List<Producto> carroCompra) {
		this.carroCompra = carroCompra;
	}
	
	
	

}
