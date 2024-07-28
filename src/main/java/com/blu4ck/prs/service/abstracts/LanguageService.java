package com.blu4ck.prs.service.abstracts;

import com.blu4ck.prs.dto.requests.CreateLanguageRequest;
import com.blu4ck.prs.dto.requests.UpdateLanguageRequest;
import com.blu4ck.prs.dto.responses.GetAllLanguageResponse;
import com.blu4ck.prs.dto.responses.GetByIdLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();
    GetByIdLanguageResponse getById(Long id);
    void create(CreateLanguageRequest createLanguageRequest);
    void delete(Long id);
    void update(UpdateLanguageRequest updateLanguageRequest);
}
