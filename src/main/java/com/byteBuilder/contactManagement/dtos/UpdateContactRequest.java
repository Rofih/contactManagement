package com.byteBuilder.contactManagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateContactRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
