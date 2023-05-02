package com.example.ecrf.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ResponseeCRF {
    private Long id;
    private String status;
    private String created_At;
    private String filling_status;
    private String pat_id;
}
