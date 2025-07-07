package com.jose.pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.pedidos.dto.ClienteDTO;
import com.jose.pedidos.service.IClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    //crear cliente
    @PostMapping
    public ClienteDTO guardarCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        return clienteService.guardarCliente(clienteDTO);
    }

    //listar todos los clientes
    @GetMapping
    public List<ClienteDTO> listarClientes(){
        return clienteService.listarClientes();
    }

    //buscar cliente por id
    @GetMapping("/{id}")
    public ClienteDTO buscarClientePorId(@PathVariable Long id){
        return clienteService.buscarClientePorId(id);
    }

    //eliminar cliente
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id){
        clienteService.eliminarCliente(id);
    }
    
    
    
    
}
