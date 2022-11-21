package dev.jefferson.userapi.dto;

import dev.jefferson.shoppingclient.dto.UserDTO;
import dev.jefferson.userapi.model.User;

public class DTOConverter {
	
	public static UserDTO convert(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome(user.getNome());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setKey(user.getKey());
		userDTO.setDataCadastro(user.getDataCadastro());
		return userDTO;
	}

}
