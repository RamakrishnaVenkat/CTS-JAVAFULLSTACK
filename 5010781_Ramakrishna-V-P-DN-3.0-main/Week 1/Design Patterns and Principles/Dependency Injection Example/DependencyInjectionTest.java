// DependencyInjectionTest.java
public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the repository into the service
        CustomerService service = new CustomerService(repository);

        // Use the service to find a customer
        Customer customer = service.findCustomerById("1");
        System.out.println(customer);

        customer = service.findCustomerById("2");
        System.out.println(customer);
    }
}
