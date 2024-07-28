package com.blu4ck.prs.dataAccess;

import com.blu4ck.prs.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
    boolean existsByName(String name);
}
