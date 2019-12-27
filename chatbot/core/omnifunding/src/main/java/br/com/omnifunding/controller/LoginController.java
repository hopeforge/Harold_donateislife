package br.com.omnifunding.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnifunding.model.Usuario;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	
	  @PostMapping("/auth/login")
	  public Usuario login(@RequestBody Usuario usuario) {
		  if(usuario.getEmail().equals("admin@admin.com") && usuario.getPassword().equals("admin")) {
			  usuario.setPassword(null);
			  usuario.setToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
			  return usuario;
		  } else {
			  return null;
		  }
	  }
	  
	  @RequestMapping(value = "/auth/logout", method = RequestMethod.DELETE)
	  public Boolean logout() {
		  return true;
	  }
	  
}
