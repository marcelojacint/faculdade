package com.hotel.infrastructure.repository;

import com.hotel.domain.entity.Quarto;
import com.hotel.domain.enums.StatusQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    List<Quarto> findByStatus(StatusQuarto status);

    boolean existsByNumero(String numero);
}
