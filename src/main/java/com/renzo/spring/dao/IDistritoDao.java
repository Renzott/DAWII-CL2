package com.renzo.spring.dao;

import com.renzo.spring.model.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistritoDao extends JpaRepository<Distrito,Integer> {
}
