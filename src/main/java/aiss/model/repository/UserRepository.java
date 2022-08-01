package aiss.model.repository;

import java.util.Collection;

import aiss.model.api.User;

public interface UserRepository {
	public Collection<User> getAll();
	public void put(User u);
	public User get(String id);
	public void remove(User u);
}