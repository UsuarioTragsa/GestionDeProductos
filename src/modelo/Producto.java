package modelo;

public class Producto {
	
	private String nombre;
	private double precio;
	private String descripcionProducto;
	private int cantidad;
	private String categoria;
	
	
	public Producto(String nombre, double precio, String descripcionProducto, int cantidad, String categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.descripcionProducto = descripcionProducto;
		this.cantidad = cantidad;
		this.categoria = categoria;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getDescripcionProducto() {
		return descripcionProducto;
	}


	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}
