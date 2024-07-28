package com.blu4ck.prs.service.concretes;

import com.blu4ck.prs.core.mapper.ModelMapperService;
import com.blu4ck.prs.dataAccess.DescriptionRepository;
import com.blu4ck.prs.dto.requests.CreateDescriptionRequest;
import com.blu4ck.prs.dto.requests.UpdateDescriptionRequest;
import com.blu4ck.prs.dto.responses.GetAllDescriptionResponse;
import com.blu4ck.prs.entity.Description;
import com.blu4ck.prs.service.abstracts.DescriptionService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DescriptionManager implements DescriptionService {
    private final DescriptionRepository descriptionRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void delete(Long id) {
        this.descriptionRepository.deleteById(id);
    }

    @Override
    public List<GetAllDescriptionResponse> getAll() {
        List<Description> descriptions = descriptionRepository.findAll();
        return descriptions.stream().map(description -> this.modelMapperService.forResponse().map(description, GetAllDescriptionResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void create(CreateDescriptionRequest createDescriptionRequest) {
    Description description = this.modelMapperService.forRequest().map(createDescriptionRequest,Description.class);
    this.descriptionRepository.save(description);

    }

    @Override
    public void update(UpdateDescriptionRequest updateDescriptionRequest) {
    Description description =this.modelMapperService.forRequest().map(updateDescriptionRequest,Description.class);
    this.descriptionRepository.save(description);
    }
}
