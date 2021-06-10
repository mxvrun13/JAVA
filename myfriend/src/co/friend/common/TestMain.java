package co.friend.common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMain {
	public static void main(String[] args) {
		String host = "smtp.naver.com";
		String user = "mxvrun13@naver.com"; //발신자의 이메일 아이디를 입력 
		String password = "";
		
		Properties props = new Properties(); 
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", 465); 
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("mxvrun13@naver.com"));
			message.setSubject("테스트");
			message.setText("테스트 입니다.");
			Transport.send(message);
			System.out.println("Success Message Send");
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
		}
	}
}













