package com.mbi.loan.originating.system;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import java.lang.Long;

@Component("ApplicationMain")

public class ApplicationMain implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(ApplicationMain.class.getName());
	 
	 @Override
		public void execute(DelegateExecution execution) throws Exception {
		 
		 
	        // Setting the default email variables
	        String to = "vivekmali448@gmail.com";
	        String from = "vivekmali317@gmail.com";
	        String subject = "Loan Approval";
	       
	        
	        String approvalnotification =(String)execution.getVariable("approvalstatus");
	        String text="Hey ! Your leave has been "+execution.getVariable("approvalstatus");
	        // Sending email notification
	       
	        
	       
	        GmailSender gEmailSender = new GmailSender();
	        boolean b = gEmailSender.sendEmail(to, from, subject, text);
	        
	        // Checking if email sent successfully
	        if (b) {
	            System.out.println("Email notification sent successfully.");
	        } else {
	            System.out.println("There was a problem sending the email notification.");
	        }

	      
		 
	 }
}