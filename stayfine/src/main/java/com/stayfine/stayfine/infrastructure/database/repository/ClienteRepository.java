package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.ClienteDBEntity;
import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteDBEntity, Long> {

    boolean existsByIdAndStatus(Long id, String status);
}
