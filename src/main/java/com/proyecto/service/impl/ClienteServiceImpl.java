package com.proyecto.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.model.ClienteEntity;
import com.proyecto.repository.ClienteRepository;
import com.proyecto.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    
    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> listadoClients() {
        // TODO Auto-generated method stub
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarClientePorId(Integer id) {
        // TODO Auto-generated method stub
        return clienteRepository.findById(id).get();
    }
    
}
