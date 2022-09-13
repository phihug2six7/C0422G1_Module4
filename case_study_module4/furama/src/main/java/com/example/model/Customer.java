package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String dateOfBirth;
    private int gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String address;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customerType",referencedColumnName = "id")
    private CustomerType customerType;
    @JsonBackReference
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
