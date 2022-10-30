package me.whiteship.refactoring._21_alternative_classes_with_different_interfaces._02_after;

public class OrderAlerts {

    /**
     * 여기서 더하여 List<NotificationService> 이렇게 만들어서 확장성을 가질 수 있음
     */
    private NotificationService notificationService;

    public OrderAlerts(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void alertShipped(Order order) {
        Notification notification = Notification.newNotification(order.toString() + " is shipped")
                .receiver(order.getEmail());
        notificationService.sendNotification(notification);
    }

}
