package com.atomsistemas.cursomc.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.atomsistemas.cursomc.domain.Categoria;
import com.atomsistemas.cursomc.repositories.CategoriaRepository;
import com.atomsistemas.cursomc.services.execptions.DateIntegrityException;
import com.atomsistemas.cursomc.services.execptions.ObjectNotFoundExecption;

@Service
public class CategoriaService {
    @Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) { 
	 Optional<Categoria>obj = repo.findById(id); 
	  return obj.orElseThrow(() -> new ObjectNotFoundExecption("Objeto não Encontrado! Id:" + id + ", Tipo:" + Categoria.class.getName()));
	}
	//CRUD Insert
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	//CRUD Update
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	//CRUD delete DELETE Api Json
	
public void delete(Integer id) {
	find(id);
	try {
	repo.deleteById(id);
	}
	catch(DataIntegrityViolationException e) {
		throw new DateIntegrityException("Não possivel excluir uma categoria que tem produtos");
	}
  }
//CRUD DTO lista de categorias Api Json
 public List<Categoria> findAll(){
	 return repo.findAll();
	 
 }
//Paginação com parametro de requisição
 public Page<Categoria> findPage(Integer page, Integer linesPerPage, String ordemBy, String direction){
 PageRequest pageRequest = PageRequest.of (page,linesPerPage, Direction.valueOf(direction), ordemBy);
 return repo.findAll(pageRequest);
}
 }
