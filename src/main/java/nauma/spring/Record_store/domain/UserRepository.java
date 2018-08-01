package nauma.spring.Record_store.domain;

import org.springframework.data.repository.CrudRepository;

import nauma.spring.Record_store.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}