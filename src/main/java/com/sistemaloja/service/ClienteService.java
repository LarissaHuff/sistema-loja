package com.sistemaloja.service;

import com.sistemaloja.dto.ClienteDTO;
import com.sistemaloja.dto.ClienteViewDTO;
import com.sistemaloja.model.CestoCompras;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void cadastrar(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTipoDocumento(clienteDTO.tipoDocumento());
        cliente.setNumeroDocumento(clienteDTO.numeroDocumento());

        clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        clienteRepository.delete(cliente);
    }

    public ClienteViewDTO getByid(Long id) {
        return new ClienteViewDTO(clienteRepository.findById(id).orElseThrow());
    }

    public List<CestoCompras> findCesto(Long idCliente) {
        Cliente cliente = findById(idCliente);
        return cliente.getCestoCompras();
    }

    public List<ClienteViewDTO> getAll() {
        List<Cliente> clienteList = clienteRepository.findAll();
        return clienteList.stream()
                .map(ClienteViewDTO::new)
                .toList();
    }

    public void update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteDTO.nome());
        cliente.setDataNascimento(clienteDTO.dataNascimento());
        cliente.setTipoDocumento(clienteDTO.tipoDocumento());
        cliente.setNumeroDocumento(clienteDTO.numeroDocumento());

        clienteRepository.save(cliente);
    }

    public Cliente findById(Long idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow();
    }
}
