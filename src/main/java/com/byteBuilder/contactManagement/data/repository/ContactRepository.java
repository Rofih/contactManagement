package com.byteBuilder.contactManagement.data.repository;

import com.byteBuilder.contactManagement.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Optional<Contact> findByPhoneNumber(String phoneNumber);

    Optional<Contact> findByFirstName(String firstName);

}
