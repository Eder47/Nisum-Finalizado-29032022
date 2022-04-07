package com.springboot.servicio.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.nisum.usuarioscommons.models.entity.Usuario;
import com.springboot.servicio.app.oauth.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		info.put("nombre", usuario.getNombre());
		info.put("apellido", usuario.getApellido());
		info.put("correo", usuario.getEmail());
		info.put("telefono", usuario.getTelefono());
		info.put("fechaCreacion", usuario.getFechaCreacion().toString());
		if(usuario.getUltimoIngreso()!= null) {
			info.put("ultimoIngreso", usuario.getUltimoIngreso().toString());
		}
		if(usuario.getFechaModificacion() != null) {
			info.put("fechaModificacion", usuario.getFechaModificacion().toString());
		}
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
