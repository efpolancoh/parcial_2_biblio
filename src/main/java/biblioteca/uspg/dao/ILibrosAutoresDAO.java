package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.LibrosAutores;

public interface ILibrosAutoresDAO extends JpaRepository<LibrosAutores,Integer>{

}
