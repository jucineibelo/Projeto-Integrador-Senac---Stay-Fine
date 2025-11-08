package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.PessoaDBEntity;
import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaDBEntity, Long> {
}
