package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "informacion de autor")
@Entity
@Table(name="autor")
public class Autor {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_autor;
	
	@Column(name ="nombre_apellido",nullable=false, length=100)
	String nombre_apellido;
	
	
	@Column(name ="pais",nullable=false, length=100)
	String pais;
	

	public Integer getId_autor() {
		return id_autor;
	}

	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}


	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	
	
}
