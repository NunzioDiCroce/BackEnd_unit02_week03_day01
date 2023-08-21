package com.example.Unit02Week03Day01.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Unit02Week03Day01.entities.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {

}
