package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Destino;

public interface DestinoServices {



    List<Destino> getAllDestino();
	
	Destino getDestinoById(Long id);
	
	Destino saveDestino(Destino Destino);
	
	Destino updateDestino(Long id, Destino DestinoUpdated);
	
	void deleteById(Long id);
    
}