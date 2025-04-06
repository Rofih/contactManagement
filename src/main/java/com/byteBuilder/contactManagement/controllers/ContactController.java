package com.byteBuilder.contactManagement.controllers;

import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.dtos.UpdateContactRequest;
import com.byteBuilder.contactManagement.services.ContactInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
