package com.blu4ck.prs.service.concretes;

import com.blu4ck.prs.core.mapper.ModelMapperService;
import com.blu4ck.prs.dataAccess.TechRepository;
import com.blu4ck.prs.dto.requests.CreateTechRequest;
import com.blu4ck.prs.dto.requests.UpdateTechRequest;
import com.blu4ck.prs.dto.responses.GetAllTechResponse;
import com.blu4ck.prs.dto.responses.GetByIdTechResponse;
import com.blu4ck.prs.entity.Tech;
import com.blu4ck.prs.service.abstracts.TechService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TechManager implements TechService {
private TechRepository techRepository;
private ModelMapperService modelMapperService;

    @Override
    public List<GetAllTechResponse> getAll() {
        List<Tech> techList =techRepository.findAll();
        return techRepository.findAll().stream().map(tech -> this.modelMapperService.forResponse().map(tech,GetAllTechResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdTechResponse getById(Long id) {
        Tech tech = this.techRepository.findById(id).orElseThrow();
              return this.modelMapperService.forResponse().map(tech,GetByIdTechResponse.class);
    }

    @Override
    public void create(CreateTechRequest createTechRequest) {
    Tech tech = this.modelMapperService.forRequest().map(createTechRequest,Tech.class);
    this.techRepository.save(tech);
    }

    @Override
    public void delete(Long id) {
    this.techRepository.deleteById(id);
    }

    @Override
    public void update(UpdateTechRequest updateTechRequest) {
    Tech tech = this.modelMapperService.forRequest().map(updateTechRequest,Tech.class);
    this.techRepository.save(tech);
    }
}
