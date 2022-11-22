package dev.jefferson.shoppingapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dev.jefferson.shoppingclient.dto.UserDTO;
import dev.jefferson.shoppingclient.exceptions.UserNotFoundException;

@Service
public class UsuarioService {
	
	
	public UserDTO getUserByCpf(final String cpf, final String key) {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/user/cpf" + cpf + "?key=" + key;
			
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(url, UserDTO.class);
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException(e.getMessage());
		}
	}

}
