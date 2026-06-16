package guru.springframework.sfgbreweryapi.services;

import guru.springframework.sfgbreweryapi.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, Customer> customerMap = new HashMap<>();

    public CustomerServiceImpl() {

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("John Doe")
                .email("john@example.com")
                .phoneNumber("12345678")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Jane Smith")
                .email("jane@example.com")
                .phoneNumber("87654321")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Bob Johnson")
                .email("bob@example.com")
                .phoneNumber("11223344")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {

        log.debug("Getting customer by id: {}", id);

        return Optional.ofNullable(customerMap.get(id));
    }

    @Override
    public Customer saveNewCustomer(Customer customer) {

        Customer savedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName(customer.getCustomerName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        customerMap.put(savedCustomer.getId(), savedCustomer);

        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID customerId, Customer customer) {

        Customer existing = customerMap.get(customerId);

        existing.setCustomerName(customer.getCustomerName());
        existing.setEmail(customer.getEmail());
        existing.setPhoneNumber(customer.getPhoneNumber());
        existing.setUpdatedDate(LocalDateTime.now());

        customerMap.put(existing.getId(), existing);
    }

    @Override
    public void patchCustomerById(UUID customerId, Customer customer) {

        Customer existing = customerMap.get(customerId);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existing.setCustomerName(customer.getCustomerName());
        }

        if (StringUtils.hasText(customer.getEmail())) {
            existing.setEmail(customer.getEmail());
        }

        if (StringUtils.hasText(customer.getPhoneNumber())) {
            existing.setPhoneNumber(customer.getPhoneNumber());
        }

        existing.setUpdatedDate(LocalDateTime.now());
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }
}