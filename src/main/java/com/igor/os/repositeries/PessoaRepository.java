package com.igor.os.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.igor.os.domain.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	
	@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
	Pessoa findByCPF(@Param("cpf")String cpf);

}
