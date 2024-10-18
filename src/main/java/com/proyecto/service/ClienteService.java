package com.proyecto.service;

import java.util.List;

import com.proyecto.model.ClienteEntity;

public interface ClienteService {
    List<ClienteEntity> listadoClients();
    ClienteEntity buscarClientePorId(Integer id);
}
