package com.igor.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.os.domain.Pessoa;
import com.igor.os.domain.Tecnico;
import com.igor.os.dtos.TecnicoDTO;
import com.igor.os.repositeries.PessoaRepository;
import com.igor.os.repositeries.TecnicoRepository;
import com.igor.os.services.exceptions.DataIntegratyViolationsException;
import com.igor.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Tecnico.class.getName()));

	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationsException("CPF Já cadastrado na base de dados!");
		}
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));

	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldOBJ = findById(id);
		
		 if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			 throw new DataIntegratyViolationsException("CPF Já cadastrado na base de dados!");
			 
		 }
		 
		 oldOBJ.setNome(objDTO.getNome());
		 oldOBJ.setCpf(objDTO.getCpf());
		 oldOBJ.setTelefone(objDTO.getTelefone());
		 return repository.save(oldOBJ);
		 
	}
		
	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if(obj.getList().size() > 0)
		repository.deleteById(id);
		throw new DataIntegratyViolationsException("Tecnicos possui ordens de serviço, não pode ser deletado!!");
		
	}
	//Busca tecnico por cpf
	private Pessoa findByCPF(TecnicoDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}

		return null;
	}

	

}
