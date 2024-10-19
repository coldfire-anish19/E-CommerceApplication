package com.gl.customerservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Getter
@Setter
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String location;
    @Column(unique = true)
   private String contactNumber;
}
