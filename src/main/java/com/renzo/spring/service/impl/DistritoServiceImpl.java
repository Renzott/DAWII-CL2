package com.renzo.spring.service.impl;

import com.renzo.spring.commons.GenericServiceImpl;
import com.renzo.spring.dao.IDistritoDao;
import com.renzo.spring.model.Distrito;
import com.renzo.spring.service.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DistritoServiceImpl extends GenericServiceImpl<Distrito, Integer> implements IDistritoService {

    @Autowired
    private IDistritoDao distritoDao;

    @Override
    public JpaRepository<Distrito, Integer> getDao() {
        return distritoDao;
    }
}
