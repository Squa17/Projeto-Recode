package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.springmvc.entities.Usuario;
import br.com.rehab.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByName(String name);

}
