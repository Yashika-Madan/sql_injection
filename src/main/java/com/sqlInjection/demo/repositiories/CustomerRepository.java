package com.sqlInjection.demo.repositiories;

import com.sqlInjection.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM CUSTOMER WHERE username = ?1 AND password = ?2", nativeQuery = true)
    public Customer getCustomer(String uname, String password);
}
