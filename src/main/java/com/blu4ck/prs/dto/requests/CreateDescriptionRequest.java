package com.blu4ck.prs.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDescriptionRequest {
    private String specs;
    private Long techId;
}
