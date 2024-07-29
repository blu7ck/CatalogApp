package com.blu4ck.prs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDescriptionResponse {
    private Long id;
    private String specs;
    private String techName;
    private String languageName;
}