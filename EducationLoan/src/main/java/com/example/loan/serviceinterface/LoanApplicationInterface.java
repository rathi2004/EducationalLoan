package com.example.loan.serviceinterface;

import java.util.List;

import com.example.loan.model.LoanApplicationModel;

public interface LoanApplicationInterface {
	
	public List<LoanApplicationModel> getAllLoan();
	public LoanApplicationModel postLoanApplication(LoanApplicationModel id);
	public LoanApplicationModel putLoanApplication(LoanApplicationModel id);
	public void deleteLoanApplicationModel(int id);

}
