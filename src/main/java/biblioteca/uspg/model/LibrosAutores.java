package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="librosAutores")
public class LibrosAutores {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_librosAutores;
	
	@Column(name ="id_libro",nullable=false, length=100)
	Integer id_libro;
	
	@Column(name ="id_autor",nullable=false, length=100)
	Integer id_autor;

	public Integer getId_librosAutores() {
		return id_librosAutores;
	}

	public void setId_librosAutores(Integer id_librosAutores) {
		this.id_librosAutores = id_librosAutores;
	}

	public Integer getId_libro() {
		return id_libro;
	}

	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}

	public Integer getId_autor() {
		return id_autor;
	}

	public void setId_autor(Integer id_autor) {
		this.id_autor = id_autor;
	}
}
