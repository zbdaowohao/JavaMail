package sendMail;

import model.SendMailInfo;

public class Run {

	public static void main(String[] args) {
		MailService sendMail = new MailService();
		SendMailInfo mailInfo = new SendMailInfo();
		mailInfo.setSendTo("houbowen470@163.com");
		mailInfo.setSendSubject("注册成功还差最后一步");
		mailInfo.setSendContext(
				"<h1>激活邮件点击以下连接:</h1><h3><a href='http://www.baidu.com?hbw'>http://www.baidu.com" + "?hbw" + "</a></h3>");
		sendMail.sendMail(mailInfo);
	}

}
