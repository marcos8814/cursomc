package com.atomsistemas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomsistemas.cursomc.domain.Cliente;
import com.atomsistemas.cursomc.repositories.ClienteRepository;
import com.atomsistemas.cursomc.services.execptions.ObjectNotFoundExecption;

@Service
public class ClienteService {
    @Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) { 
	 Optional<Cliente>obj = repo.findById(id); 
	  return obj.orElseThrow(() -> new ObjectNotFoundExecption("Objeto não Encontrado! Id:" + id + ", Tipo:" + Cliente.class.getName()));
	}
	
}
