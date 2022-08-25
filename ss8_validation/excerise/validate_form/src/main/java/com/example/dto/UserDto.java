package com.example.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    private int id;

    @NotBlank(message = "Yêu cầu nhập không để trống")
    @Pattern(regexp = "\\w+",message = "Nhập chữ không nhập số")
    @Size(min =5,max =45)
    private String firstName;

    @NotBlank(message = "Yêu cầu nhập không để trống")
    @Pattern(regexp = "\\w+",message = "Nhập chữ không nhập số")
    @Size(min =5,max =45)
    private String lastName;

    @NotBlank(message = "Yêu cầu nhập không để trống")
    @Pattern(regexp = "^0[1-9][0-9]{8}$",
            message = "Nhập số 0 đầu tiên thì 10 số,nếu số khác thì 9 số")
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate age ;

    @NotBlank(message = "Yêu cầu nhập không để trống")
    @Email(message = "Nhập đúng định dạng của Email")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, LocalDate age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto=(UserDto) target;
        try{
            LocalDate age= userDto.getAge();
            LocalDate day= LocalDate.now();
            if (Period.between(age,day).getYears()<18||Period.between(age,day).getYears()>100){
                errors.rejectValue("age","age.error","18-100");
            }
        }catch (Exception e){
            errors.rejectValue("age","age.notnull","Please input right format");
        }

    }
}
