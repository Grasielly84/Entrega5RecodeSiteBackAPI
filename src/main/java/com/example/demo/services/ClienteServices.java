package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Cliente;

public interface ClienteServices {



    List<Cliente> getAllCliente();
	
	Cliente getClienteById(Long id);
	
	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Long id, Cliente clienteUpdated);
	
	void deleteById(Long id);
    
}
