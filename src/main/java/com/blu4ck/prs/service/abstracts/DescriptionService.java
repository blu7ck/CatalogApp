package com.blu4ck.prs.service.abstracts;

import com.blu4ck.prs.dto.requests.CreateDescriptionRequest;
import com.blu4ck.prs.dto.requests.UpdateDescriptionRequest;
import com.blu4ck.prs.dto.responses.GetAllDescriptionResponse;

import java.util.List;

public interface DescriptionService {
    void delete(Long id);
    List<GetAllDescriptionResponse> getAll();
    void create(CreateDescriptionRequest createDescriptionRequest);
    void update(UpdateDescriptionRequest updateDescriptionRequest);
}
