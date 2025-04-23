package com.learning.Employees;

import com.learning.Employees.dto.EmployeeDTO;
import com.learning.Employees.exception.RequestValidationException;
import com.learning.Employees.validation.EmployeeValidations;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeValidationsTest {

    @Test
    public void testValidEmployeeShouldPass() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstname("praveena");
        dto.setLastname("jaison");
        dto.setEmail("jaison.john@gmail.com");
        dto.setPhonenumber("9876543210");
        dto.setAddress("Kollam");

        assertDoesNotThrow(() -> EmployeeValidations.validateEmployee(dto));
    }

    @Test
    public void testEmptyFirstNameShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstname("");
        dto.setLastname("jaison");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("First name is required", exception.getMessage());
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, exception.getStatus());
    }

    @Test
    public void testEmptyLastNameShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstname("praveena");
        dto.setLastname("");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Last name is required", exception.getMessage());
    }

    @Test
    public void testInvalidEmailShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmail("invalid-email");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Invalid email", exception.getMessage());
    }

    @Test
    public void testEmptyEmailShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmail("");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Email is required", exception.getMessage());
    }

    @Test
    public void testInvalidPhoneNumberShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setPhonenumber("123");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testEmptyPhoneNumberShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setPhonenumber("");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Phone number is required", exception.getMessage());
    }

    @Test
    public void testEmptyAddressShouldThrowException() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setAddress("");

        RequestValidationException exception = assertThrows(RequestValidationException.class,
                () -> EmployeeValidations.validateEmployee(dto));
        assertEquals("Address is required", exception.getMessage());
    }
}

