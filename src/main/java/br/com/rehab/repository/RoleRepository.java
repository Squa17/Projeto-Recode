package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.springmvc.entities.Role;
import br.com.rehab.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByAuthority(String authority);

}
