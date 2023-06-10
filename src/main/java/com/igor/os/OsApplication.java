package com.igor.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igor.os.domain.Cliente;
import com.igor.os.domain.OS;
import com.igor.os.domain.Tecnico;
import com.igor.os.domain.enums.Prioridade;
import com.igor.os.domain.enums.Status;
import com.igor.os.repositeries.ClienteRepository;
import com.igor.os.repositeries.OSRepository;
import com.igor.os.repositeries.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository OSRepository;

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico t1 = new Tecnico(null, "Igor Aguiar" , "531.869.470-57", "(11)98888-8888");
		Cliente c1 = new Cliente(null, "Betina Campos" , "368.095.830-76", "(11)98888-7777");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste Create OS", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		OSRepository.saveAll(Arrays.asList(os1));
		
		
		
	}

}
  