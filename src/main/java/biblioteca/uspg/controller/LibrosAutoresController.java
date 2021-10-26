package biblioteca.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import biblioteca.uspg.exception.ModeloNotFoundException;

import biblioteca.uspg.model.LibrosAutores;

import biblioteca.uspg.service.ILibrosAutoresService;

@RestController
@RequestMapping ("/librosAutores")
public class LibrosAutoresController {
	@Autowired
	private ILibrosAutoresService service;
	
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)public 
		ResponseEntity<List<LibrosAutores>>listar(){
		return new ResponseEntity<List<LibrosAutores>>(service.listar(), HttpStatus.OK); 
	}
	
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<LibrosAutores> listarPorId(@PathVariable("id") Integer id){ 
		Optional<LibrosAutores> librosAutores = service.listarPorId(id);
		
		if(!librosAutores.isPresent()) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO:  " + id);
		}
			
		
		EntityModel<LibrosAutores>resource = EntityModel.of(librosAutores.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("autor-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid LibrosAutores librosAut_){
		
		LibrosAutores librosAutores = service.registrar(librosAut_);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(librosAutores.getId_librosAutores()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	
	
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody LibrosAutores libAutores){
		Optional< LibrosAutores> librosAutores=service.listarPorId(libAutores.getId_librosAutores());
		
		if(!librosAutores.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + libAutores.getId_librosAutores());
		 }else {
			 service.modificar(libAutores);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		 
		 //return service.modificar(autor); 
	}

	@DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<LibrosAutores> librosAutores = service.listarPorId(id);
		 if(!librosAutores.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		 
	}
	
	
	
}
