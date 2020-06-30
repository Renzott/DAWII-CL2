package com.renzo.spring.dao;

import com.renzo.spring.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente,Integer> {
}
