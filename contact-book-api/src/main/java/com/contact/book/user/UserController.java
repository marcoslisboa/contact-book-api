package com.contact.book.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable Long id) {
		return repository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User add(@RequestBody User user) {
		User model = new User();
		model.read(user);
		return repository.saveAndFlush(model);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, @RequestBody User user) {
		User model = repository.findOne(id);
		if (model != null) {
			model.read(user);
			return repository.saveAndFlush(model);
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repository.delete(id);
	}
}