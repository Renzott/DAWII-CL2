package com.renzo.spring.service.impl;

import ch.qos.logback.core.net.server.Client;
import com.renzo.spring.commons.GenericServiceImpl;
import com.renzo.spring.dao.IClienteDao;
import com.renzo.spring.model.Cliente;
import com.renzo.spring.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente,Integer> implements IClienteService {

    @Autowired
    private IClienteDao clienteDAO;


    @Override
    public JpaRepository<Cliente, Integer> getDao() {
        return clienteDAO;
    }
}
