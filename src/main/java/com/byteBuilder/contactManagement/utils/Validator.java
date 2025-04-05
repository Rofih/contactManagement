package com.byteBuilder.contactManagement.utils;

import com.byteBuilder.contactManagement.data.models.Contact;
import jakarta.validation.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void validateContact(Contact contact) {
//        if (contact == null) {
//            throw new IllegalArgumentException("Contact cannot be null");
//        }
        if (!isValidString(contact.getFirstName())){
            throw new ValidationException("First name is not valid");
        }
        if (!isValidPhone(contact.getPhoneNumber())){
            throw new ValidationException("Phone number is not valid");
        }
        if (contact.getOtherInfo().getEmail() != null){
            boolean status = isValidEmail(contact.getOtherInfo().getEmail());
            if (!status){
                throw new ValidationException("Email is not valid");
            }
        }

    }
    private static boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static boolean isValidPhone(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            return false;
        }
        String phoneRegex = "^[0-9]{11}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    private static boolean isValidString(String string) {
        if (string.isEmpty()) {
            return false;
        } else return !string.isBlank();
    }
}
