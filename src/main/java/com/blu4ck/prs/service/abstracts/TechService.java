package com.blu4ck.prs.service.abstracts;

import com.blu4ck.prs.dto.requests.CreateTechRequest;
import com.blu4ck.prs.dto.requests.UpdateTechRequest;
import com.blu4ck.prs.dto.responses.GetAllTechResponse;
import com.blu4ck.prs.dto.responses.GetByIdTechResponse;
import java.util.List;

public interface TechService {
    List<GetAllTechResponse> getAll();
    GetByIdTechResponse getById(Long id);
    void create(CreateTechRequest createTechRequest);
    void delete(Long id);
    void update(UpdateTechRequest updateTechRequest);

}
