package biblioteca.uspg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.ILibrosAutoresDAO;
import biblioteca.uspg.model.LibrosAutores;
import biblioteca.uspg.service.ILibrosAutoresService;
@Service
public class LibrosAutoresServiceImpl implements ILibrosAutoresService {
	@Autowired
	private ILibrosAutoresDAO dao;
	
	@Override
	public LibrosAutores registrar(LibrosAutores t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public LibrosAutores modificar(LibrosAutores t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Optional<LibrosAutores> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(null);
	}

	@Override
	public List<LibrosAutores> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
