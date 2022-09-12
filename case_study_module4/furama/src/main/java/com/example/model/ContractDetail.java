package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_facility_id",referencedColumnName = "id")
    private AttachFacility attachFacility;
}
