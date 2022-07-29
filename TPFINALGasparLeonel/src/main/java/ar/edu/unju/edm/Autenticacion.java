package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
@Component
@EnableWebSecurity 
public class Autenticacion implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new  DefaultRedirectStrategy(); 
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//
		 Boolean tipoCliente = false ;
		 Boolean tipoAdmin = false; 
		 
		 Collection <?extends GrantedAuthority>autorizacion = authentication.getAuthorities();
		 
		 for(GrantedAuthority grantedAutority:autorizacion) {
			 if(grantedAutority.getAuthority().equals("CLIENTE")) {
				 tipoCliente=true;
				 break;
			 }
			 else {
				 if(grantedAutority.getAuthority().equals("ADMIN")) {
					 tipoAdmin=true;
					 break;
				 }
			 }
		 }
		 if(tipoCliente) {
			 redirectStrategy.sendRedirect(request, response, "/index2");
		 }
		 else {
			 if(tipoAdmin) {
				 redirectStrategy.sendRedirect(request, response, "/listadoUsuario");
			 }
		 }
	}

}
