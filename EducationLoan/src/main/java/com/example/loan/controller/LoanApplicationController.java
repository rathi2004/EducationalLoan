package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.LoanApplicationModel;
import com.example.loan.repository.LoanApplicationRepository;
import com.example.loan.service.LoanApplicationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
public class LoanApplicationController {
	
	
	@Autowired
	LoanApplicationService ls;
	
	@Autowired
	LoanApplicationRepository lr;
	
	@Tag(name="Get",description="get data")
	@GetMapping("/alloan")
	public List<LoanApplicationModel> getAllLoanDetails(){
		return ls.getAllLoan();
	}
	
	@Tag(name="post",description="post data")
	@PostMapping("/postloan")
	
	public String postLoanDetails(@RequestBody LoanApplicationModel id) {
		
		ls.postLoanApplication(id);
		return "Loan application details are posted";
	}
	
	@PutMapping("/putloan")
	
	public String putLoanDetails(@RequestBody LoanApplicationModel id) {
		ls.putLoanApplication(id);
		return "Loan application details are updated";
	}
	
	@DeleteMapping("/deleteloan/{id}")
	public String deleteLoanDetails(@PathVariable int id) {
		
		ls.deleteLoanApplicationModel(id);
		return "Loan application details are deleted";
	}
	
	@PutMapping("/loan/{id}")
	 public ResponseEntity<LoanApplicationModel> updateFlight(@PathVariable("id") int id, @RequestBody LoanApplicationModel loan){
		LoanApplicationModel b = lr.findById(id).get();
	      if(b.getLoanId()!=0) {
	        b.setLoantype(loan.getLoantype());
	        b.setApplicantName(loan.getApplicantName());
	        b.setApplicantAddress(loan.getApplicantAddress());
	        b.setApplicantMobile(loan.getApplicantMobile());
	        b.setApplicantEmail(loan.getApplicantEmail());
	        b.setApplicantAadhaar(loan.getApplicantAadhaar());
	        b.setApplicantPan(loan.getApplicantPan());
	        b.setApplicantSalary(loan.getApplicantSalary());
	        b.setLoanAmountRequired(loan.getLoanAmountRequired());
	        b.setLoanRepaymentMonths(loan.getLoanRepaymentMonths());
	       
	       
	      }
	  return new ResponseEntity<LoanApplicationModel>(lr.save(b),HttpStatus.OK);
	 }
	
	

}
