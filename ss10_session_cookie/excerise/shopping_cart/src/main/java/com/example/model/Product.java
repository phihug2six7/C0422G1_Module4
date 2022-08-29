package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private String imgLink;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Product product = (Product) o;
        return id== product.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
