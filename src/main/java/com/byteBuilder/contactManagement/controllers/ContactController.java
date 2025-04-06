package com.byteBuilder.contactManagement.controllers;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.dtos.UpdateContactRequest;
import com.byteBuilder.contactManagement.services.ContactInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/contact")
public class ContactController {
    @Autowired
    private ContactInterface contactService;

    @PostMapping("/add_contact")
    public CreateResponse addContact(@RequestBody CreateRequest request) {
        return contactService.createContact(request);
    }
    @PostMapping("/update_contact")
    public CreateResponse updateContact(@RequestBody UpdateContactRequest request) {
        return contactService.updateContactPhoneNumber(request);
    }

    @GetMapping("/get_contact/{phoneNumber}")
    public Contact getContactByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return contactService.getContactByPhoneNumber(phoneNumber);
    }

    @GetMapping("/get_contacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }
}
