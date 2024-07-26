package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.naming.Name;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="Item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    private String rentalPerDay;
    private String finePerDay;
    private String availability;
}