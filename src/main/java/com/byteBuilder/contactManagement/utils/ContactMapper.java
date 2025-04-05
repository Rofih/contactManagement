package com.byteBuilder.contactManagement.utils;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;

public class ContactMapper {
    public static Contact mapContact(CreateRequest createRequest) {
        Contact contact = new Contact();
        contact.setFirstName(createRequest.getFirstName());
        contact.setLastName(createRequest.getLastName());
        contact.setOtherInfo(createRequest.getOtherInfo());
        contact.setPhoneNumber(createRequest.getPhoneNumber());
        return contact;
    }
    public static CreateResponse mapCreateResponse(Contact contact){
        CreateResponse contactResponse = new CreateResponse();
        contactResponse.setName(contact.getFirstName() + contact.getLastName());
        contactResponse.setPhoneNumber(contact.getPhoneNumber());
        return contactResponse;
    }
}
