package com.byteBuilder.contactManagement.services;

import com.byteBuilder.contactManagement.data.models.Contact;
import com.byteBuilder.contactManagement.data.models.Info;
import com.byteBuilder.contactManagement.data.repository.ContactRepository;
import com.byteBuilder.contactManagement.dtos.CreateRequest;
import com.byteBuilder.contactManagement.dtos.CreateResponse;
import com.byteBuilder.contactManagement.dtos.UpdateContactRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepo;


    @AfterEach
    void tearDown() {
        contactRepo.deleteAll();
    }


    @Test
    void test_That_I_Can_Create_A_Contact() {
        //Given
        CreateRequest createRequest = new CreateRequest();
        createRequest.setFirstName("John");
        createRequest.setLastName("Doe");
        createRequest.setPhoneNumber("09127461933");
        Info otherInfo = new Info();
        otherInfo.setEmail("john@gmail.com");
        otherInfo.setAddress("Block 12 Flat A");
        createRequest.setOtherInfo(otherInfo);

        //When
        CreateResponse createResponse = contactService.createContact(createRequest);

        //Then
        assertNotNull(createResponse);
        Contact foundContact = contactRepo.findByPhoneNumber("09127461933").orElse(null);
        assertNotNull(foundContact);
        assertEquals(createRequest.getFirstName(), foundContact.getFirstName());
        assertEquals(createRequest.getLastName(), foundContact.getLastName());
        assertEquals(createRequest.getOtherInfo().getEmail(), foundContact.getOtherInfo().getEmail());


    }

    @Test
    void test_That_I_Can_Update_A_Contact() {
        //Given
        CreateRequest createRequest = new CreateRequest();
        createRequest.setFirstName("John");
        createRequest.setLastName("Doe");
        createRequest.setPhoneNumber("09127461933");
        Info otherInfo = new Info();
        otherInfo.setEmail("john@gmail.com");
        otherInfo.setAddress("Block 12 Flat A");
        createRequest.setOtherInfo(otherInfo);


        UpdateContactRequest updateContactRequest = new UpdateContactRequest();
        updateContactRequest.setPhoneNumber("08023353223");
        updateContactRequest.setFirstName("John");
        updateContactRequest.setLastName("Doe");

        //When
        CreateResponse createResponse = contactService.createContact(createRequest);
        assertNotNull(createResponse);
        CreateResponse updateResponse = contactService.updateContactPhoneNumber(updateContactRequest);
        assertNotNull(updateResponse);
        //Then

    }


}