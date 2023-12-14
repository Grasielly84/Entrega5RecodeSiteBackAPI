package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Compra;
import com.example.demo.repository.CompraRepository;
import com.example.demo.services.CompraServices;

import jakarta.persistence.EntityNotFoundException;


@Service
public class CompraServicesImpl implements CompraServices {
    
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> getAllCompra() {
       return compraRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Compra getCompraById(Long id) {
       return compraRepository.findById(id).orElse(null);
    }

    @Override
    public Compra saveCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public Compra updateCompra(Long id, Compra compraUpdated) {
       Compra compraExiste=compraRepository.findById(id).orElse(null);
       if (compraExiste!=null) {
        compraExiste.setNome(compraUpdated.getNome());
        compraExiste.setValor(compraUpdated.getValor());
        return compraRepository.save(compraExiste);
       }

       else {
            throw new EntityNotFoundException("Compra com ID " + id + " não encontrada");
        }
    }

    @Override
    public void deleteById(Long id) {
        compraRepository.deleteById(id);
    }

    
}
