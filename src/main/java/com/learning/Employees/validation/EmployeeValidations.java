package com.learning.Employees.validation;

import com.learning.Employees.dto.EmployeeDTO;
import com.learning.Employees.exception.RequestValidationException;
import com.mysql.cj.util.StringUtils;
import org.springframework.http.HttpStatus;


import java.util.regex.Pattern;

public class EmployeeValidations {


    private static  final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+?[0-9]{1,4})?[0-9]{10}$");

    public static void ValidateEmployee(EmployeeDTO employeeDTO){

        if(employeeDTO.getFirstname() != null && StringUtils.isNullOrEmpty(employeeDTO.getFirstname())){
            throw new RequestValidationException("First name is required", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if(employeeDTO.getLastname() != null && StringUtils.isNullOrEmpty(employeeDTO.getLastname())){
            throw new RequestValidationException("Last name is required", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if(employeeDTO.getEmail() != null) {
            if (StringUtils.isNullOrEmpty(employeeDTO.getEmail())) {
                throw new RequestValidationException("Email is required", HttpStatus.UNPROCESSABLE_ENTITY);
            } else if (!EMAIL_PATTERN.matcher(employeeDTO.getEmail()).matches()) {
                throw new RequestValidationException("Invalid email", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        if (employeeDTO.getPhonenumber() != null) {
            if (StringUtils.isNullOrEmpty(employeeDTO.getPhonenumber())) {
                throw new RequestValidationException("Phone number is required", HttpStatus.UNPROCESSABLE_ENTITY);
            } else if (!PHONE_PATTERN.matcher(employeeDTO.getPhonenumber()).matches()) {
                throw new RequestValidationException("Invalid phone number", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        if(employeeDTO.getAddress() != null && StringUtils.isNullOrEmpty(employeeDTO.getAddress())){
            throw new RequestValidationException("Address is required", HttpStatus.UNPROCESSABLE_ENTITY);
        }



    }


}
