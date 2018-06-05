package com.homewin.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil implements  Runnable {
	private String email;
	private String code;
	
	
	public MailUtil(String email, String code) {
		super();
		this.email = email;
		this.code = code;
	}


	@Override
	public void run() {
		// 1.�������Ӷ���javax.mail.Session
				// 2.�����ʼ����� javax.mail.Message
				// 3.����һ�⼤���ʼ�
		String send="1583418506@qq.com";//���÷��͵����䣬��Ҫ����smtpЭ��
		String host="smtp.qq.com";//qq�����õ�����
		Properties properties =System.getProperties();//��ȡϵͳ����
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		try {
			//QQ������Ҫ������δ��룬163���䲻��Ҫ
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			// 1.��ȡĬ��session����
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("1583418506@qq.com", "pwbisdrorktojcdb"); // �����������˺š���Ȩ��
				}
			});
			//�����ʼ�����
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(send));//������ַ
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));//���յ�ַ
			message.setSubject("�˺ż���");
			String content = "<html><head></head><body><h1>����һ�⼤���ʼ�,����������������</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
					+ code + "'>http://localhost:8080/MailTest/ActiveServlet?code=" + code
					+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 3.�����ʼ�
			Transport.send(message);
			System.out.println("�ʼ��ɹ�����!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

} 
