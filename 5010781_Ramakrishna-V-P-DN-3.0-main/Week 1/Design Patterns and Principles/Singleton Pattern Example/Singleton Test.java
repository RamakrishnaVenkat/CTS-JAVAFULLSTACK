// SingletonTest.java
public class SingletonTest {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Verify that both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different instances exist.");
        }

        // Test the logging functionality
        logger1.log("This is a log message.");
        logger2.log("This is another log message.");
    }
}
