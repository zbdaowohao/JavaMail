package sendMail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import model.SendMailInfo;
import utils.CommonUtils;

public class MailService {

	private static final Logger logger = Logger.getLogger(MailService.class);
	/** 邮箱服务器 */
	private static String host = CommonUtils.readProperties("properties", "sendMail_host");
	/** 服务器登录人 */
	private static String userName = CommonUtils.readProperties("properties", "sendMail_userName");
	/** 服务器登录密码 */
	private static String password = CommonUtils.readProperties("properties", "sendMail_password");

	public void sendMail(SendMailInfo mailInfo) {
		Properties props = new Properties();
		// 使用认证信息，来登录到邮箱服务器
		props.put("mail.smtp.host", host);
		props.put("username", userName);
		props.put("password", password);
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		// 创建连接对象，连接到服务器
		Session mailSession = Session.getDefaultInstance(props);
		/*
		 * Session mailSession = Session.getDefaultInstance(props, new
		 * Authenticator() {
		 * 
		 * @Override protected PasswordAuthentication
		 * getPasswordAuthentication() { return new
		 * PasswordAuthentication(userName, password); } });
		 */

		// 创建邮件对象
		Message message = new MimeMessage(mailSession);

		Transport transport = null;
		try {
			// 设置发件人
			message.setFrom(new InternetAddress(userName));
			// 设置收件人
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailInfo.getSendTo()));
			// 设置邮件主题
			message.setSubject(mailInfo.getSendSubject());
			// 设置邮件正文(非文本网页)
			message.setContent(mailInfo.getSendContext(), "text/html;charset=UTF-8");
			// 发送邮件
			// message.setSentDate(new Date());//设置发送的时间
			transport = mailSession.getTransport("smtp");
			transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("username"),
					props.getProperty("password"));
			transport.sendMessage(message, message.getAllRecipients());
		} catch (AddressException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} finally {
			try {
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
				logger.error(e.toString());
			}
		}
	}

}
