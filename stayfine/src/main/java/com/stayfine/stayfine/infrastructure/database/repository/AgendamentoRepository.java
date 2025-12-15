package com.stayfine.stayfine.infrastructure.database.repository;

import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;

public interface AgendamentoRepository extends JpaRepository<AgendamentoDBEntity, Long> {

    @Query("""
                SELECT COUNT(a) > 0
                FROM AgendamentoDBEntity a
                WHERE a.profissional.id = :profissionalId
                  AND a.dataAgendamento BETWEEN
                        FUNCTION('TIMESTAMPADD', MINUTE, -15, :horario)
                    AND FUNCTION('TIMESTAMPADD', MINUTE,  15, :horario)
            """)
    boolean existeConflito(Long profissionalId, LocalDateTime horario);

    boolean existsByIdAndStatus(Long id, String status);

    boolean existsByDataAgendamento(LocalDateTime dataAgendamento);

    @Modifying
    @Query("UPDATE AgendamentoDBEntity a SET a.status = :status WHERE a.id = :id")
    int atualizarStatus(Long id, String status);

}
