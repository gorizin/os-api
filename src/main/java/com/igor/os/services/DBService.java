package com.igor.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.os.domain.Cliente;
import com.igor.os.domain.OS;
import com.igor.os.domain.Tecnico;
import com.igor.os.domain.enums.Prioridade;
import com.igor.os.domain.enums.Status;
import com.igor.os.repositeries.ClienteRepository;
import com.igor.os.repositeries.OSRepository;
import com.igor.os.repositeries.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	
	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Igor Aguiar", "961.512.170-39", "(11) 98888-8888");
		Cliente c1 = new Cliente(null, "Betina Campos", "457.794.500-21", "(11) 97777-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));

	}

}
