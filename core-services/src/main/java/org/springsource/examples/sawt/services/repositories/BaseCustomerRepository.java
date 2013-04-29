package org.springsource.examples.sawt.services.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springsource.examples.sawt.services.model.Customer;
import org.springsource.examples.sawt.services.repositories.jpa.CustomerRepositoryCustom;

import java.math.BigInteger;
import java.util.Collection;

/**
 * functionality that we expect Spring Data to implement
 *
 * @author Josh Long
 */
public interface BaseCustomerRepository extends PagingAndSortingRepository<Customer, BigInteger>, CustomerRepositoryCustom {
    Collection<Customer> findByFirstName(String firstName);

    Collection<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
