package com.blu4ck.prs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdLanguageResponse {
    private Long id;
    private String name;
}
