package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<ProfissionalDBEntity, Long> {

    @Query("SELECT p FROM ProfissionalDBEntity p " +
            "WHERE p.status = 'ATIVO'")
    List<ProfissionalDBEntity> listarAtivos();

    boolean existsByIdAndStatus(Long id, String status);
}
