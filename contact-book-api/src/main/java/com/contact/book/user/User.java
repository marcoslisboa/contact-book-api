package com.contact.book.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.contact.book.user.enums.UserType;

/**
 * 
 * @author Marcos Lisboa
 *
 */
@Entity
@Table(name = "t_user", schema = "public")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotEmpty
	@Column(name = "login", nullable = false)
	private String login;
	
	@NotEmpty
	@Email
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotEmpty
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotEmpty
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type", nullable = false)
	private UserType type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	public void read(User outher) {
		this.setName(outher.getName());
		this.setEmail(outher.getEmail());
		this.setLogin(outher.getLogin());
		this.setPassword(outher.getPassword());
		this.setType(outher.getType());
	}

	
}
