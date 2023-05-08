package com.example.loan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.loan.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {

	UserModel findByEmail(String email);
	Optional<UserModel> findOneByEmailAndPassword(String email,String password);
}
