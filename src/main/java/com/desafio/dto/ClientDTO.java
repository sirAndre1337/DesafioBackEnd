package com.desafio.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.desafio.entities.Client;
import com.desafio.services.validation.ClientValid;

@ClientValid
public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@Size(min = 2, max = 20, message = "Nome deve conter entre 2 e 20 caracteres.")
	private String name;
	@CPF
	private String cpf;
	@Positive(message = "O valor deve ser positivo.")
	private Double income;
	@PastOrPresent(message = "A data não pode ser futura.")
	private Instant birthDate;
	@Positive(message = "O valor deve ser positivo.")
	private Integer children;
	
	@Size(min = 2, max = 20, message = "Nome deve conter entre 2 e 20 caracteres.")
	@NotBlank(message = "Campo login requerido.")
	private String login;
	@Size(min = 5, max = 20, message = "Password deve conter entre 5 e 20 caracteres.")
	@NotBlank(message = "Campo password requerido.")
	private String password;
	
	private Set<RoleDTO> roles = new HashSet<>();

	public ClientDTO() {
	}

	public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children , String login , String password) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
		this.login = login;
		this.password = password;
	}

	public ClientDTO(Client entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
		login = entity.getLogin();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		return Objects.equals(id, other.id);
	}

}
