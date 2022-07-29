package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Pelicula;
import ar.edu.unju.edm.model.Usuario;
//la interface dice que hace
@Service
public interface IUsuarioService {
    //el servi tiene que guardar usuario 
	public void guardarUsuario(Usuario usuario ) ;
	public List <Usuario> mostrarUsuario();
	public void eliminarUsuario(Integer id) throws Exception;
	public void modificarUsuario(Usuario usuario);
	public Usuario buscarUsuario(Integer id) throws Exception;
	public Usuario encontrarConCorreo(String email) throws Exception;
	public Usuario obtenerUsuarioID(Integer id);
}
