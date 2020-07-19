package com.atomsistemas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atomsistemas.cursomc.domain.Pedido;
import com.atomsistemas.cursomc.repositories.PedidoRepository;
import com.atomsistemas.cursomc.services.execptions.ObjectNotFoundExecption;

@Service
public class PedidoService {
    @Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) { 
	 Optional<Pedido>obj = repo.findById(id); 
	  return obj.orElseThrow(() -> new ObjectNotFoundExecption("Objeto não Encontrado! Id:" + id + ", Tipo:" + Pedido.class.getName()));
	}
	
}
