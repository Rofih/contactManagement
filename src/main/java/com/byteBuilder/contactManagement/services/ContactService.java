package com.byteBuilder.contactManagement.services;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.data.repository.ContactRepository;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.dtos.UpdateContactRequest;
import com.byteBuilder.contactManagement.utils.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.byteBuilder.contactManagement.utils.Validator.validateContact;
@Service
public class ContactService implements ContactInterface{
    @Autowired
    private ContactRepository contactRepo;

    @Override
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

@Override
public List<Contact> getAllContacts() {
    return contactRepo.findAll();
}

@Override
public CreateResponse updateContactPhoneNumber(UpdateContactRequest updateContactRequest) {
    Optional<Contact> foundContact = contactRepo.findByFirstName(updateContactRequest.getFirstName());
    if (foundContact.isPresent()){
        Contact contact = foundContact.get();
        contact.setPhoneNumber(updateContactRequest.getPhoneNumber());
        contactRepo.save(contact);
        CreateResponse response = ContactMapper.mapCreateResponse(contact);
        response.setMessage("contact successfully updated");
        return response;
    }
    else {
        throw new RuntimeException("Contact not found");
    }
}

@Override
public Contact getContactByPhoneNumber(String phoneNumber) {
    Optional<Contact> foundContact = contactRepo.findByPhoneNumber(phoneNumber);
    if (foundContact.isPresent()){
        return foundContact.get();
    }
    else {
        throw new RuntimeException("Contact not found");
    }
}
}
