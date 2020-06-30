package com.renzo.spring.service.impl;

import com.renzo.spring.commons.GenericServiceImpl;
import com.renzo.spring.dao.ITipoClienteDao;
import com.renzo.spring.model.TipoCliente;
import com.renzo.spring.service.ITipoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoClienteServiceImpl extends GenericServiceImpl<TipoCliente,Integer> implements ITipoClienteService {

    @Autowired
    private ITipoClienteDao tipoClienteDao;

    @Override
    public JpaRepository<TipoCliente, Integer> getDao() {
        return tipoClienteDao;
    }
}
