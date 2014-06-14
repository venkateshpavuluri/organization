package com.mnt.mail;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.ResourceReqDetail;
import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.bean.Status;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MailService {

	 

    private MailSender mailSender;
    private Set userEmailIds;
    public Set getUserEmailIds() {
		return userEmailIds;
	}
	public void setUserEmailIds(Set userEmailIds) {
		this.userEmailIds = userEmailIds;
	}
	public MailSender getMailSender() {

        return mailSender;

    }
    public void setMailSender(MailSender mailSender) {

        this.mailSender = mailSender;

    }
    public void uponSuccessfulRegistration(String[] emailCCList){
        //SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[userEmailIds.size()];
    	SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[1];
        Iterator iterator = userEmailIds.iterator();
       // for (int index = 0; iterator.hasNext(); index ++){
            SimpleMailMessage message = new SimpleMailMessage();
            String toAddress = (String)iterator.next();
            message.setFrom("thotaparvathidevi@gmail.com");
            message.setTo("durgasridevi.salugu@mntsoft.co.in");
            message.setSubject("With CC");
            message.setCc(emailCCList);
            message.setText("Mail Sent from @parvathi@gmail.com");
            mailMessageArray[0] = message;
// }
        mailSender.send(mailMessageArray);
    }
public void hrmail(Object object){
	SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[1];
    //Iterator iterator = userEmailIds.iterator();
   // for (int index = 0; iterator.hasNext(); index ++){
        SimpleMailMessage message = new SimpleMailMessage();
        String description=null;
        int noOfPositions=0;
        String requiredDate=null;
        String priority=null;
        ResourceRequest resReq=(ResourceRequest)object;
       int id=Integer.parseInt(resReq.getEmployeeId());
       System.out.println("the id is:"+id);
		List<ResourceReqDetail> listEdit = resReq.getResourceReqDetail();
		
		Iterator<ResourceReqDetail> iterate = listEdit.iterator();
		while (iterate.hasNext()) {
			Object object2 = iterate.next();
			ResourceReqDetail resRdit = (ResourceReqDetail) object2;
			noOfPositions=resRdit.getNoOfPositions();		
 description=resRdit.getJobDescription();
 requiredDate=resRdit.getRequiredDate();
 priority=resRdit.getPriority();
		}
        //String toAddress = (String)iterator.next();
        message.setFrom("thotaparvathidevi@gmail.com");
        message.setTo("hr@mntsoft.co.in");
     
        message.setText("Hi"+"\n\nThis is the Resource Request Details."+"\n\nResource Request Details:"+"\n\n   Employee Id          :"+resReq.getEmployeeId()+"\n   Resource Request Date:"+resReq.getResourceReqDate()+"\n   Number Of Positions  :"+noOfPositions+"\n   Job Description      :"+description+"\n   Required Date        :"+requiredDate+"\n   Priority             :"+priority+"\n\n\n\n\n\n\nThanks & Regards\n\nProject Manager\nMNT SOFT PVT LTD");
        mailMessageArray[0] = message;
//}
    System.out.println("Sending email ....");
    mailSender.send(mailMessageArray);
    System.out.println("Sent email ....");
}
public void sendingMessageForEmp(Set<String> emailCCList){
    //SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[userEmailIds.size()];
	SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[1];
    Iterator iterator = emailCCList.iterator();
   // for (int index = 0; iterator.hasNext(); index ++){
    while(iterator.hasNext())
    {
    String mailids=(String)iterator.next();
        SimpleMailMessage message = new SimpleMailMessage();
        String toAddress = (String)iterator.next();
        message.setFrom("thotaparvathidevi@gmail.com");
        message.setTo("durgasridevi.salugu@mntsoft.co.in");
        message.setSubject("With CC");
        message.setCc(mailids);
        message.setText("Mail Sent from @parvathi@gmail.com");
        mailMessageArray[0] = message;
//}

    System.out.println("Sending email ....");
    mailSender.send(mailMessageArray);
    System.out.println("Sent email ....");
    }

}
}

