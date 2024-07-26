package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Item {

    private Long itemId;
    private String name;
    private String rentalPerDay;
    private String finePerDay;
    private String availability;
}