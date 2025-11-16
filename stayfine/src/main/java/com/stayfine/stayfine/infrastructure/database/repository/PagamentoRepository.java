package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.PagamentoDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PagamentoRepository extends JpaRepository<PagamentoDBEntity, Long> {
    boolean existsByIdAndStatus(Long id, String status);
}
