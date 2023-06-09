package com.example.repostitory;

import com.example.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/***
 * @description:
 * @author: yk
 * @date:
 * @param:
 * @return:
 **/
public interface PersonRepository extends CrudRepository<Person,String> {
    List<Person> findByLastname(String lastname);

    Page<Person> findPersonByLastname(String lastname, Pageable page);

    List<Person> findByFirstnameAndLastname(String firstname, String lastname);

    List<Person> findByAddressCity(String city);

    List<Person> findByFamilyListUsername(String username);
}
