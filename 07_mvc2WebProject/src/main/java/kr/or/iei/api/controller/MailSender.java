package kr.or.iei.api.controller;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	public boolean sendMail(String mailTitle, String receiver, String mailContent) {
		boolean result = false;
		//이메일 통신설정
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587); //서버에서 받아주는 포트라서 고정
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.stmp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		//인증정보설정(로그인)
		Session session = Session.getDefaultInstance(prop,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication(){ 
						PasswordAuthentication pa = new PasswordAuthentication("kingodribo", "oaunjzydycobijrq");
						return pa;
					}
				}//import는 무조건 javax.mail로!
		
				);//이메일 작성해서 전송하는 객체
				
				MimeMessage msg = new MimeMessage(session);
				
				try {
					//메일전송날짜설정
					msg.setSentDate(new Date());
					//보내는 사람 정보 설정
					msg.setFrom(new InternetAddress("kingodribo@gmail.com","KH 당산 A클래스"));
					//받는사람정보
					InternetAddress to = new InternetAddress(receiver);
					msg.setRecipient(Message.RecipientType.TO, to);
					//이메일 제목설정
					msg.setSubject(mailTitle,"UTF-8");
					//이메일 내용(본문 설정)
					msg.setContent(mailContent, "text/html;charset=utf-8");
					//이메일전송
					Transport.send(msg);
					result = true;
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return result;
	}//sendMail

	public String sendMail2(String email) {
				boolean result = false;
				//이메일 통신설정
				Properties prop = System.getProperties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", 587);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", true);
				prop.put("mail.stmp.ssl.protocols", "TLSv1.2");
				prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				//인증정보설정(로그인)
				Session session = Session.getDefaultInstance(prop,
						new Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication(){ 
								PasswordAuthentication pa = new PasswordAuthentication("kingodribo", "oaunjzydycobijrq");
								return pa;
							}
						}//import는 무조건 javax.mail로!
				
						);//이메일 작성해서 전송하는 객체
						
						MimeMessage msg = new MimeMessage(session);
						//인증을 위한 랜덤코드 생성
						//영어 소문자, 영어 대문자, 숫자 8자리
						Random r = new Random();
						StringBuffer sb = new StringBuffer();
						for(int i=0;i<8;i++) {
							//0 ~ 9 : r.nextInt(10) -> 0부터 매개변수 개수중 랜덤수 1개
							//A ~ Z : (char)(r.nextInt(26)+65); ->아스키코드,알파벳은 26개
							//a ~ z : (char)(r.nextInt(26)+97);
							//0~2
							int flag = r.nextInt(3);
							if(flag == 0) {
								//0~9
								int randomNumber = r.nextInt(10);
								sb.append(randomNumber);
							}else if(flag == 1) {
								//A-Z
								char randomChar = (char)(r.nextInt(26)+65);	
								sb.append(randomChar);
							}else if(flag == 2) {
								//a~z
								char randomChar = (char)(r.nextInt(26)+97);
								sb.append(randomChar);
							}
						}
						//이메일 작성
						
						try {
							//메일전송날짜설정
							msg.setSentDate(new Date());
							//보내는 사람 정보 설정
							msg.setFrom(new InternetAddress("kingodribo@gmail.com","KH 당산 A클래스"));
							//받는사람정보
							InternetAddress to = new InternetAddress(email);
							msg.setRecipient(Message.RecipientType.TO, to);
							//이메일 제목설정
							msg.setSubject("골드키위 인증메일입니다","UTF-8");
							//이메일 내용(본문 설정)
							msg.setContent("<h1>안녕하세요 골드키위입니다</h1>"
											+"<h3>인증번호는 [<span style='color:red;'>"
											+sb.toString()
											+"</span>]입니다.</h3>"
											, "text/html;charset=utf-8");
							//이메일전송
							Transport.send(msg);
							result = true;
						} catch (MessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(result) {
							return sb.toString();
						}else {
							return null;
						}
			}//sendMail
	}
