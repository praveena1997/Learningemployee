package com.learning.Employees.dto;

import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String address;
}
