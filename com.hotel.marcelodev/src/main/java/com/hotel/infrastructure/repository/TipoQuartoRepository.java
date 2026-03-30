package com.hotel.infrastructure.repository;

import com.hotel.domain.entity.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoQuartoRepository  extends JpaRepository<TipoQuarto, Long>{
}
