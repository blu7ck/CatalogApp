package com.blu4ck.prs.dataAccess;

import com.blu4ck.prs.entity.Tech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<Tech,Long> {
}
