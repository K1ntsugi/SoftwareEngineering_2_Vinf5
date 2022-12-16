enum NotificationType { Support, Developer }

    abstract class NotifyService {
        void notifyAboutUserQuestion(String t) { sendMessage(NotificationType.Support, t); }

        void notifyAboutException(Exception exp) {
            sendMessage(NotificationType.Developer, Arrays .stream(exp.getStackTrace())
                    .map(el -> el.toString ()).collect(Collectors.joining()));
        }

        private void sendMessage(NotificationType type, String messageContent) {
            getTarget(notificationType).send(messageContent);
        }

        protected abstract CommunicationTarget getTarget (NotificationType notificationType);
    }

    class MailNotifyService extends NotifyService {
        private final MailTarget target = new MailTarget();

        protected CommunicationTarget getTarget(NotificationType type) { return target; }
    }

    class PushNotifyService extends NotifyService {
        private final PushNotificationTarget target = new PushNotificationTarget();

        protected CommunicationTarget getTarget(NotificationType type) { return target; }
    }

    class ComplexNotifyService extends NotifyService {
        private final MailTarget mailTarget = new MailTarget();

        private final PushNotificationTarget pushNotificationTarget
            = new PushNotificationTarget();

        protected CommunicationTarget getTarget(NotificationType notificationType) {
            return switch (notificationType) {
                case Support -> mailTarget;
                case Developer -> pushNotificationTarget;
                default -> throw new RuntimeException("Unsupported notification type!");
            };
        }
    }

    interface CommunicationTarget { void send (String data); }  

    class MailTarget implements CommunicationTarget {
        public void send(String data) { System.out.println("Send data via email: " + data); }
    }

    class PushNotificationTarget implements CommunicationTarget {
        public void send(String data) {System.out.println("Send data via push notification: "
            + data);
        }
    }