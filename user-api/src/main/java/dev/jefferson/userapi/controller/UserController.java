package dev.jefferson.userapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.shoppingclient.dto.UserDTO;
import dev.jefferson.userapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;

	public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}
	
	
	@PostMapping
	public UserDTO add(@RequestBody UserDTO userDTO) {
		return service.save(userDTO);
	}
	
	
	@GetMapping
	public List<UserDTO> getUsers(){
		return service.getAll();
	}
	
	
	@GetMapping("/cpf/{cpf}")
	public UserDTO getByCpf(@PathVariable String cpf, @RequestParam(name = "key", required = true) String key) {
		return service.findByCpf(cpf, key);
	}
	
	
	@GetMapping("{id}")
	public UserDTO getById(@PathVariable long id) {
		return service.findById(id);
	}
	
	
	@GetMapping("/search")
	public List<UserDTO> search(@RequestParam(name = "nome", required = true) String nome) {
		return service.queryByName(nome);
	}
	

	@PostConstruct
	public void initiateList() {
		UserDTO userDTO = new UserDTO();
		userDTO.setNome("Eduardo");
		userDTO.setCpf("123");
		userDTO.setEndereco("Rua a");
		userDTO.setEmail("eduardo@email.com");
		userDTO.setTelefone("1234-3454");
		userDTO.setDataCadastro(new Date());
		
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setNome("Luiz");
		userDTO2.setCpf("456");
		userDTO2.setEndereco("Rua b");
		userDTO2.setEmail("luiz@email.com");
		userDTO2.setTelefone("1234-3454");
		userDTO2.setDataCadastro(new Date());
		
		UserDTO userDTO3 = new UserDTO();
		userDTO3.setNome("Bruna");
		userDTO3.setCpf("678");
		userDTO3.setEndereco("Rua c");
		userDTO3.setEmail("bruna@email.com");
		userDTO3.setTelefone("1234-3454");
		userDTO3.setDataCadastro(new Date());
		
		usuarios.add(userDTO);
		usuarios.add(userDTO2);
		usuarios.add(userDTO3);
	}
}
