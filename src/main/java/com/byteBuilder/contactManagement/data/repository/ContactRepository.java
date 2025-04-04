package com.byteBuilder.contactManagement.data.repository;

import com.byteBuilder.contactManagement.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
