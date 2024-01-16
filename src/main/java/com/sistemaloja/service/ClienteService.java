package com.sistemaloja.service;

import com.sistemaloja.model.CestoCompras;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<CestoCompras> findCesto(Long idCliente) {
        Cliente cliente = findById(idCliente);
        List<CestoCompras> cestoCompras = cliente.getCestoCompras();
        return cestoCompras;
    }

    public Cliente findById(Long idCliente) {
        return clienteRepository.findById(idCliente).orElseThrow();
    }
}
