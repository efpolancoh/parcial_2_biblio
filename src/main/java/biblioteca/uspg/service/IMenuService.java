package biblioteca.uspg.service;


import java.util.List;

import biblioteca.uspg.model.Menu;

public interface IMenuService extends ICRUD<Menu>{
	
	List<Menu> listarMenuPorUsuario(String nombre);
}
