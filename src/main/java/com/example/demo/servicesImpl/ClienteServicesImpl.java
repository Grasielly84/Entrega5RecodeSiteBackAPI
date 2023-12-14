package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.services.ClienteServices;

import jakarta.persistence.EntityNotFoundException;




@Service
public class ClienteServicesImpl implements ClienteServices {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllCliente() {
       return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Cliente getClienteById(Long id) {
       return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteUpdated) {
       Cliente clienteExiste=clienteRepository.findById(id).orElse(null);
       if (clienteExiste!=null) {
        clienteExiste.setNome(clienteUpdated.getNome());
        clienteExiste.setCpf(clienteUpdated.getCpf());
        clienteExiste.setEndereco(clienteUpdated.getEndereco());
        clienteExiste.setTelefone(clienteUpdated.getTelefone());
        clienteExiste.setLoguin(clienteUpdated.getLoguin());
        clienteExiste.setSenha(clienteUpdated.getSenha());
        return clienteRepository.save(clienteExiste);
       }

       else {
            throw new EntityNotFoundException("Cliente com ID " + id + " não encontrada");
        }
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
