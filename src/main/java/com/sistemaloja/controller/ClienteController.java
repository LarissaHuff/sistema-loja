package com.sistemaloja.controller;

import com.sistemaloja.dto.ClienteDTO;
import com.sistemaloja.dto.ClienteViewDTO;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTipoDocumento(clienteDTO.tipoDocumento());
        cliente.setNumeroDocumento(clienteDTO.numeroDocumento());

        clienteRepository.save(cliente);

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(cliente);

    }

    @GetMapping("/{id}")
    public ClienteViewDTO getByid(@PathVariable Long id){
       return new ClienteViewDTO (clienteRepository.findById(id).orElseThrow());
    }

    @GetMapping
    public List<ClienteViewDTO> getAll(){
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream()
                .map(ClienteViewDTO::new)
                .toList();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody ClienteDTO clienteDTO){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTipoDocumento(clienteDTO.tipoDocumento());
        cliente.setNumeroDocumento(clienteDTO.numeroDocumento());

        clienteRepository.save(cliente);

    }
}
