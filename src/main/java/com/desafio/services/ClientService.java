package com.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.dto.ClientDTO;
import com.desafio.entities.Client;
import com.desafio.repositories.ClientReposity;
import com.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientReposity reposity;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPageable(PageRequest pageRequest) {
		Page<Client> clients = reposity.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = reposity.findById(id);
		Client client = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO saveClient(ClientDTO dto) {
		Client client = new Client();
		copyDtoToEntity(dto, client);
		client = reposity.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO updatecliente(long id, ClientDTO dto) {
		findById(id);
		Client client = new Client();
		client.setId(id);
		copyDtoToEntity(dto, client);
		client = reposity.save(client);
		return new ClientDTO(client);
	}

	public void deleteCliente(long id) {
		try {
			reposity.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("id not found " + id);
		}
	}

	private void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
	}
}