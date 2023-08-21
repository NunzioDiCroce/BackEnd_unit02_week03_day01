package com.example.Unit02Week03Day01.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Unit02Week03Day01.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {

	Optional<Utente> findByEmail(String email);

}
