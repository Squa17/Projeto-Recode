package br.com.rehab.services;

import java.util.List;

//import com.springmvc.dto.UsuarioDTO;
import br.com.rehab.dto.UsuarioDTO;
//import com.springmvc.entities.Usuario;
import br.com.rehab.entities.Usuario;



public interface UsuarioService {

	List<UsuarioDTO> findAllUsers();
	
	void saveUser(UsuarioDTO userDTO);
	
	Usuario findUserByName(String name);
}









 













