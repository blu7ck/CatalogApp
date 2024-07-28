package com.blu4ck.prs.dataAccess;

import com.blu4ck.prs.entity.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepository extends JpaRepository<Description,Long> {
}
