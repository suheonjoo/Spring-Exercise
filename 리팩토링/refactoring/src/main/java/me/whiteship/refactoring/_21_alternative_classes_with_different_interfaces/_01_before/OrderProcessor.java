package me.whiteship.refactoring._21_alternative_classes_with_different_interfaces._01_before;

/**
 * 지금 현재 상황이 알리는 상황을 이메일, 알람 이 2가지로 알림 시스템을 만듬 기능을 같기에 이걸 하나의 인터페이스로 만들려고 하는 것임
 */
public class OrderProcessor {

    private EmailService emailService;

    public void notifyShipping(Shipping shipping) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTitle(shipping.getOrder() + " is shipped");
        emailMessage.setTo(shipping.getEmail());
        emailMessage.setFrom("no-reply@whiteship.com");
        emailService.sendEmail(emailMessage);
    }

}
