package com.igor.os.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.os.domain.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
