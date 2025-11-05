package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<ProfissionalDBEntity, Long> {
}
