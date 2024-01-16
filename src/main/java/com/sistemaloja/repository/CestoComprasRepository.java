package com.sistemaloja.repository;

import com.sistemaloja.model.CestoCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CestoComprasRepository extends JpaRepository<CestoCompras, Long> {
}
