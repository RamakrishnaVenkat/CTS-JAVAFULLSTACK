// CustomerRepositoryImpl.java
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customers;

    public CustomerRepositoryImpl() {
        customers = new HashMap<>();
        // Adding some sample customers
        customers.put("1", new Customer("1", "John Doe"));
        customers.put("2", new Customer("2", "Jane Doe"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customers.get(id);
    }
}
