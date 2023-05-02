package com.example.ecrf.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "eCRF1")
public class eCRF1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ecrfStatus;
    private String created_At;
    private String filling_status;
    private String patId;
}
