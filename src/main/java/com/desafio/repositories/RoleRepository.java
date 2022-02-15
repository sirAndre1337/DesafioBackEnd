package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
