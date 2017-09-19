import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;


public class Sending {
public void mail(String file) throws Exception{
	 EmailAttachment attachment = new EmailAttachment();
	  attachment.setPath(file);
	  attachment.setDisposition(EmailAttachment.ATTACHMENT);
	  attachment.setDescription("Kohler Report");
	  attachment.setName("Kohler");

	  // Create the email message
	  MultiPartEmail email = new MultiPartEmail();
	  email.setHostName("smtp.miraclesoft.com");
	  email.setSmtpPort(587);
	  email.setAuthenticator(new DefaultAuthenticator("vkattamudi@miraclesoft.com", "Miracle@1"));
	  email.setSSLOnConnect(true);
	  email.addTo("rkothari@miraclesoft.com");
	  email.addTo("bpallem@miraclesoft.com");
	  email.addTo("kperla@miraclesoft.com");
	  
	  email.setFrom("vkattamudi@miraclesoft.com");
	  email.setSubject("ESS Automation Report");
	  email.setMsg("Automatic Email Reporting. Please find the attachment regarding Test case report");

	  // add the attachment
	  email.attach(attachment);

	  // send the email
	  email.send();
}

}
