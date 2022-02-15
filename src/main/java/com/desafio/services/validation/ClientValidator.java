package com.desafio.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.dto.ClientDTO;
import com.desafio.entities.Client;
import com.desafio.repositories.ClientReposity;
import com.desafio.resources.exceptions.FieldMessage;

public class ClientValidator implements ConstraintValidator<ClientValid, ClientDTO> {

	@Autowired
	private ClientReposity reposity;

	@Override
	public void initialize(ClientValid ann) {
	}

	@Override
	public boolean isValid(ClientDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à
		// lista
		Client client = reposity.findByLogin(dto.getLogin());
		if (client != null) {
			list.add(new FieldMessage("login", "Login já existe"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
