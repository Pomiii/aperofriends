package pco.aperofriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pco.aperofriends.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByRole(String role);
}
