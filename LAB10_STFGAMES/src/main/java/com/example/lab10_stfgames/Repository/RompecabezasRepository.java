package com.example.lab10_stfgames.Repository;

import com.example.lab10_stfgames.Entity.Rompecabezas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RompecabezasRepository extends JpaRepository<Rompecabezas, Integer> {
}
