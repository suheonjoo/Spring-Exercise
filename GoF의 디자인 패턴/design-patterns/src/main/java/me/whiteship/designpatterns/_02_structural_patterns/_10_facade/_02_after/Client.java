package me.whiteship.designpatterns._02_structural_patterns._10_facade._02_after;

public class Client {

    public static void main(String[] args) {
        //이메일 설정 만들기, 설정이라는 책임 가지고 있음
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");

        //이메일 송신자 만들기, 메시지를 보내는 책임을 가지고 있음
        EmailSender emailSender = new EmailSender(emailSettings);

        //이메일 메시지 만들기, 메세지 내용을 담고 있는 책임을 가지고 있음
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("keesun");
        emailMessage.setTo("whiteship");
        emailMessage.setCc("일남");
        emailMessage.setSubject("오징어게임");
        emailMessage.setText("밖은 더 지옥이더라고..");

        emailSender.sendEmail(emailMessage);
    }
}
