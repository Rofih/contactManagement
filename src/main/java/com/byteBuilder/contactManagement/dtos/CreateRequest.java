package com.byteBuilder.contactManagement.dtos;

import com.byteBuilder.contactManagement.data.models.Info;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Info otherInfo;
}
