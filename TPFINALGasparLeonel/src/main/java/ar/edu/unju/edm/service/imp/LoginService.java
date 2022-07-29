package ar.edu.unju.edm.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Usuario;
import ar.edu.unju.edm.repository.UsuarioRepository;
@Service
public class LoginService implements UserDetailsService{
  @Autowired 
  UsuarioRepository usuariorepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//busqueda de usuario
		System.out.println("kkkkkkkkkkkkkkkk "+email);
		Usuario usarioEncontrado =usuariorepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Usuario Invalido"));
		//defini autoruzaiones 
		List <GrantedAuthority> tiposPerfiles = new ArrayList<>();
		GrantedAuthority gratedauthority = new SimpleGrantedAuthority(usarioEncontrado.getTipo());
		tiposPerfiles.add(gratedauthority);
		
		//Definir el usario en sesion
		UserDetails userEnsesion =  new User(email,usarioEncontrado.getContrasena(),tiposPerfiles);
		
		
		return userEnsesion;
	}
  
	
	
}
