package com.example.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.LoanApplicationModel;
import com.example.loan.repository.LoanApplicationRepository;
import com.example.loan.serviceinterface.LoanApplicationInterface;

@Service
public class LoanApplicationService implements LoanApplicationInterface {

	@Autowired
	LoanApplicationRepository lr;
	
	@Override
	public List<LoanApplicationModel> getAllLoan() {
		
		return lr.findAll();
	}

	@Override
	public LoanApplicationModel postLoanApplication(LoanApplicationModel id) {
		
		return lr.save(id);
	}

	@Override
	public LoanApplicationModel putLoanApplication(LoanApplicationModel id) {
		
		return lr.save(id);
	}

	@Override
	public void deleteLoanApplicationModel(int id) {
		
		lr.deleteById(id);

	}

}
