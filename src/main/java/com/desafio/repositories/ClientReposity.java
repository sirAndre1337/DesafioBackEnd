package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.entities.Client;

@Repository
public interface ClientReposity extends JpaRepository<Client, Long>{

	Client findByLogin(String login);
}
