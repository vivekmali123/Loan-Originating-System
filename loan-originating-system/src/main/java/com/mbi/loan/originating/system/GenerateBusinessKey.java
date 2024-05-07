package com.mbi.loan.originating.system;

import java.util.UUID;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

@Component("generateBusinessKey")
public class GenerateBusinessKey implements ExecutionListener {

	@Override
	public void notify(DelegateExecution execution) throws Exception {
	
		UUID uuid=UUID.randomUUID();
		execution.setProcessBusinessKey("Business Key : "+uuid.toString());
		System.out.println(execution.getBusinessKey());
		System.out.println("Welcome to Loan Orginating System...");
		System.out.println("Submit Application Form.");
	}

}