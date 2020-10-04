package com.infotech4it.cibo.models;

public class NotificationModel {
    private String notificationHeading;
    private String notificationDescription;

    public NotificationModel(String notificationHeading, String notificationDescription) {
        this.notificationHeading = notificationHeading;
        this.notificationDescription = notificationDescription;
    }

    public String getNotificationHeading() {
        return notificationHeading;
    }

    public void setNotificationHeading(String notificationHeading) {
        this.notificationHeading = notificationHeading;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }
}
