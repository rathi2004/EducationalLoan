package com.example.loan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loan.model.AdminModel;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel,Integer> {

	AdminModel findByEmail(String email);
	Optional<AdminModel> findOneByEmailAndPassword(String email,String password);
}
