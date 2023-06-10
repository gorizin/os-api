package com.igor.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.os.domain.Pessoa;
import com.igor.os.domain.Cliente;
import com.igor.os.dtos.ClienteDTO;
import com.igor.os.repositeries.PessoaRepository;
import com.igor.os.repositeries.ClienteRepository;
import com.igor.os.services.exceptions.DataIntegratyViolationsException;
import com.igor.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationsException("CPF Já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));

	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldOBJ = findById(id);
		
		 if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			 throw new DataIntegratyViolationsException("CPF Já cadastrado na base de dados!");
			 
		 }
		 
		 oldOBJ.setNome(objDTO.getNome());
		 oldOBJ.setCpf(objDTO.getCpf());
		 oldOBJ.setTelefone(objDTO.getTelefone());
		 return repository.save(oldOBJ);
		 
	}
		
	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getList().size() > 0)
		repository.deleteById(id);
		throw new DataIntegratyViolationsException("Clientes possui ordens de serviço, não pode ser deletado!!");
		
	}
	//Busca tecnico por cpf
	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}

		return null;
	}

	

}
