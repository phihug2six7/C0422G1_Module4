package com.example.dto;

import com.example.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank(message = "Không nên để trống bạn nhé!")
    @Pattern(regexp = "^[A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]+( [A-ZĐ][a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâ]*)+$",
            message = "Tên khách hàng không được chứa số và ký tự đầu tiên phải viết hoa")
    private String name;

    @NotBlank
    private String dateOfBirth;
    private int gender;

    @NotBlank(message = "Không nên để trống bạn nhé!")
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$", message = "Nhập 9 số hoặc 12 số")
    private String idCard;

    @NotBlank(message = "Không nên để trống bạn nhé!")
    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))[0-9]{7}$", message = "Nhập 090 hoặc 091 với 7 số," +
            " (84+)90 với (84+)91 với 7 số")
    private String phoneNumber;

    @NotBlank(message = "Không nên để trống bạn nhé!")
    @Email(message = "Nhập đúng định dạng email nhé!")
    private String email;

    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber,
                       String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if (!customerDto.dateOfBirth.trim().equals("")) {
            try {
                LocalDate.parse(customerDto.dateOfBirth);
            } catch (Exception e) {
                errors.rejectValue("dateOfBirth", "date.err", "Nhập đúng định dạng");
            }
        }
    }
}
