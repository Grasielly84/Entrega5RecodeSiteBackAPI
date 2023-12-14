package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destino;
import com.example.demo.services.DestinoServices;

@RestController
@RequestMapping("/destino")
public class DestinoController {

    @Autowired
    private DestinoServices ss;

    @PostMapping("/savedestino")
    public Destino createDestino(@RequestBody Destino destino) {

        return ss.saveDestino(destino);
    }

    @GetMapping("/alldestino")
    public List<Destino> getAllDestino() {

        return ss.getAllDestino();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
        Destino destino = ss.getDestinoById(id);

        return ResponseEntity.ok(destino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destinoUpdated) {
        Destino destino = ss.getDestinoById(id);

        destino.setNome(destinoUpdated.getNome());
        destino.setValor(destinoUpdated.getValor());
        ss.saveDestino(destino);

        return ResponseEntity.ok(destino);
    }

    @DeleteMapping("/{id}")
    public void deleteDestino(@PathVariable Long id) {
        ss.deleteById(id);
    }

}

