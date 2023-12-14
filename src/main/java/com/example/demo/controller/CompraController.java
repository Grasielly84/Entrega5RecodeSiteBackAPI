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

import com.example.demo.model.Compra;
import com.example.demo.services.CompraServices;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraServices ss;

    @PostMapping("/savecompra")
    public Compra createCompra(@RequestBody Compra compra) {

        return ss.saveCompra(compra);
    }

    @GetMapping("/allcompra")
    public List<Compra> getAllCompra() {

        return ss.getAllCompra();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) {
        Compra compra = ss.getCompraById(id);

        return ResponseEntity.ok(compra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable Long id, @RequestBody Compra compraUpdated) {
        Compra compra = ss.getCompraById(id);

        compra.setNome(compraUpdated.getNome());
        compra.setValor(compraUpdated.getValor());

        ss.saveCompra(compra);

        return ResponseEntity.ok(compra);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        ss.deleteById(id);
    }

}
