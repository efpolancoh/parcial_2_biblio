package biblioteca.uspg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import biblioteca.uspg.model.Menu;

 
public interface IMenuDAO extends JpaRepository<Menu, Integer>{

	@Query(value="select m.* from libreria_parcial.menu_rol mr inner join libreria_parcial.usuario_rol ur on ur.id_rol = mr.id_rol inner join libreria_parcial.menu m on m.id_menu = mr.id_menu inner join libreria_parcial.usuario u on u.id_usuario = ur.id_usuario where u.nombre = :nombre", nativeQuery = true)
	List<Object[]> listarMenuPorUsuario(@Param("nombre") String nombre);
	
	//0 | [ 1, 'search', 'buscar', '/buscar']
	//1 | [ 2, 'register', 'registrar', '/consulta']
}
