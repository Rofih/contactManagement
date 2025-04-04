package com.byteBuilder.contactManagement.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact {
    @Id
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Info otherInfo;
}
