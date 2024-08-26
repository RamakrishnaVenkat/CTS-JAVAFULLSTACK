// ProxyPatternTest.java
public class ProxyPatternTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Images will be loaded from the remote server the first time
        image1.display();
        System.out.println("");

        // Images will not be loaded from the remote server again
        image1.display();
        System.out.println("");

        image2.display();
        System.out.println("");

        image2.display();
    }
}
