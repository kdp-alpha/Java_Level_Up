package com.employee.management.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    public String modelNumber;

    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id")// Optional: only needed if bidirectional
    private Student student;

    public Laptop(String brand, String modelNumber) {
        this.brand = brand;
        this.modelNumber = modelNumber;
    }

}
