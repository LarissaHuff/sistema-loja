package com.sistemaloja.controller;

import com.sistemaloja.dto.ClienteDTO;
import com.sistemaloja.dto.ClienteViewDTO;
import com.sistemaloja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public void cadastrar(@RequestBody ClienteDTO clienteDTO) {
        clienteService.cadastrar(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }

    @GetMapping("/{id}")
    public ClienteViewDTO getByid(@PathVariable Long id) {
        return clienteService.getByid(id);
    }

    @GetMapping
    public List<ClienteViewDTO> getAll() {
        return clienteService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteService.update(id, clienteDTO);
    }
}
