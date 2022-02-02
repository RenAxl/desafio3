package com.devsuperior.bds04.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.devsuperior.bds04.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	private String lastName;
	
	@Email(message = "favor entrar um email válido")
	private String email;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		id = entity.getId(); // Como não tem o mesmo nome do Parâmetro, não precisa de this. 
		firstName = entity.getFirstName(); // Como não tem o mesmo nome do Parâmetro, não precisa de this. 
		lastName = entity.getLastName(); // Como não tem o mesmo nome do Parâmetro, não precisa de this. 
		email = entity.getEmail(); // Como não tem o mesmo nome do Parâmetro, não precisa de this. 
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role))); /* Pelo fato 
	de ter sido usado o fetch = FetchType.EAGER na anotação @ManyToMany do atributo roles da classe User, 
	não foi necessário enviar as roles como parâmetro neste construtor, ou seja, não precisamos fazer o que 
	haviamos feito no construtor public ProductDTO(Product entity, Set<Category> categories) da classe 
	ProductDTO*/
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}
