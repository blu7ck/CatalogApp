package com.blu4ck.prs.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechResponse {
    private Long id;
    private String name;
    private String languageName;

}
