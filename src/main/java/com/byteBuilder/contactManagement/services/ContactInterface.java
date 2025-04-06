package com.byteBuilder.contactManagement.services;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.dtos.UpdateContactRequest;

import java.util.List;

public interface ContactInterface {
    CreateResponse createContact(CreateRequest createRequest);
    List<Contact> getAllContacts();
    CreateResponse updateContactPhoneNumber(UpdateContactRequest updateContactRequest);
    CreateResponse getContactByPhoneNumber(String phoneNumber);
}
