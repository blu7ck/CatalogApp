package com.blu4ck.prs.service.concretes;

import com.blu4ck.prs.core.exceptions.BusinessException;
import com.blu4ck.prs.core.mapper.ModelMapperService;
import com.blu4ck.prs.core.rules.LanguageRules;
import com.blu4ck.prs.dataAccess.LanguageRepository;
import com.blu4ck.prs.dto.requests.CreateLanguageRequest;
import com.blu4ck.prs.dto.requests.UpdateLanguageRequest;
import com.blu4ck.prs.dto.responses.GetAllLanguageResponse;
import com.blu4ck.prs.dto.responses.GetByIdLanguageResponse;
import com.blu4ck.prs.entity.Language;
import com.blu4ck.prs.service.abstracts.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LanguageManager implements LanguageService {
private ModelMapperService modelMapperService;
private final LanguageRepository languageRepository;
private LanguageRules languageRules;

    @Override
    public List<GetAllLanguageResponse> getAll() {
List<Language> languages = languageRepository.findAll();
return languages.stream().map(language -> this.modelMapperService.forResponse().map(language,GetAllLanguageResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetByIdLanguageResponse getById(Long id) {
        Language language = languageRepository.findById(id).orElseThrow();
        return modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
    }

    @Override
    public void create(CreateLanguageRequest createLanguageRequest) {
    this.languageRules.CheckIfBrandNameExists(createLanguageRequest.getName());
    Language language = this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
    this.languageRepository.save(language);

    }

    @Override
    public void delete(Long id) {
    this.languageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
    Language language = this.modelMapperService.forRequest().map(updateLanguageRequest,Language.class);
    this.languageRepository.save(language);
    }
}
