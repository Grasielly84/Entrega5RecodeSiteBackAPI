package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Destino;
import com.example.demo.repository.DestinoRepository;
import com.example.demo.services.DestinoServices;

import jakarta.persistence.EntityNotFoundException;


@Service
public class DestinoServicesImpl implements DestinoServices {
    
    @Autowired
    private DestinoRepository destinoRepository;
    
    @Override
    public List<Destino> getAllDestino() {
    return destinoRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Destino getDestinoById(Long id) {
       return destinoRepository.findById(id).orElse(null);
    }

    @Override
    public Destino saveDestino(Destino destino) {
        return destinoRepository.save(destino);
    }

    @Override
    public Destino updateDestino(Long id, Destino destinoUpdated) {
       Destino destinoExiste=destinoRepository.findById(id).orElse(null);
       if (destinoExiste!=null) {
        destinoExiste.setNome(destinoUpdated.getNome());
        destinoExiste.setValor(destinoUpdated.getValor());
        return destinoRepository.save(destinoExiste);
       }

       else {
            throw new EntityNotFoundException("Destino com ID " + id + " não encontrada");
        }
    }

    @Override
    public void deleteById(Long id) {
        destinoRepository.deleteById(id);
    }
    
}
