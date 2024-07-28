package com.blu4ck.prs.core.rules;

import com.blu4ck.prs.core.exceptions.BusinessException;
import com.blu4ck.prs.dataAccess.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageRules {
    private LanguageRepository languageRepository;

    public void CheckIfBrandNameExists(String name){
        if(this.languageRepository.existsByName(name)){
            throw new BusinessException("Language already exist");
        }
    }
}
