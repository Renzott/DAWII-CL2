package com.renzo.spring.dao;

import com.renzo.spring.model.TipoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoClienteDao extends JpaRepository<TipoCliente,Integer> {
}
