package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Compra;

public interface CompraServices {



    List<Compra> getAllCompra();
	
	Compra getCompraById(Long id);
	
	Compra saveCompra(Compra compra);
	
	Compra updateCompra(Long id, Compra compraUpdated);
	
	void deleteById(Long id);
    
}
