// DecoratorPatternTest.java
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorate the email notifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorate the SMS notifier with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification using all decorators
        slackNotifier.send("This is a test notification.");
    }
}
