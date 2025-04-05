package com.byteBuilder.contactManagement.services;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.data.repository.ContactRepository;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.utils.ContactMapper;
import com.mongodb.internal.bulk.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.byteBuilder.contactManagement.utils.Validator.validateContact;
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepo;

public CreateResponse createContact(CreateRequest createRequest) {
    Contact newContact = ContactMapper.mapContact(createRequest);
    validateContact(newContact);
    Optional<Contact> foundContact = contactRepo.findByPhoneNumber(newContact.getPhoneNumber());
    if (foundContact.isEmpty()) {
        contactRepo.save(newContact);
        CreateResponse response = ContactMapper.mapCreateResponse(newContact);
        response.setMessage("contact created successfully");
        return  response;
    }
    else {
        throw new RuntimeException("Contact already exists");
    }
}

public List<Contact> getAllContacts() {
    return contactRepo.findAll();
}

public CreateResponse updateContactPhoneNumber(CreateRequest createRequest) {
    Optional<Contact> foundContact = contactRepo.findByFirstName(createRequest.getFirstName());
    if (foundContact.isPresent()){
        Contact contact = foundContact.get();
        contact.setPhoneNumber(createRequest.getPhoneNumber());
        contactRepo.save(contact);
        CreateResponse response = ContactMapper.mapCreateResponse(contact);
        response.setMessage("contact successfully updated");
        return response;
    }
    else {
        throw new RuntimeException("Contact not found");
    }
}

public CreateResponse getContactByPhoneNumber(String phoneNumber) {
    Optional<Contact> foundContact = contactRepo.findByPhoneNumber(phoneNumber);
    if (foundContact.isPresent()){
        Contact contact = foundContact.get();
        return ContactMapper.mapCreateResponse(contact);
    }
    else {
        throw new RuntimeException("Contact not found");
    }
}
}
