package com.example.Unit02Week03Day01.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Unit02Week03Day01.entities.Utente;
import com.example.Unit02Week03Day01.exceptions.ItemNotFoundException;
import com.example.Unit02Week03Day01.payloads.UtentePayload;
import com.example.Unit02Week03Day01.services.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	private final UtenteService utenteService;

	@Autowired
	public UtenteController(UtenteService utenteService) {
		this.utenteService = utenteService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UtentePayload body) {
		Utente created = utenteService.save(body);
		return created;
	}

	@GetMapping("")
	public List<Utente> getUsers() {
		return utenteService.findAll();
	}

	@GetMapping("/{userId}")
	public Utente getUserById(@PathVariable UUID userId) {
		return utenteService.findById(userId);

	}

	@PutMapping("/{userId}")
	public Utente updateUser(@PathVariable UUID userId, @RequestBody UtentePayload body) {
		return utenteService.findByIdAndUpdate(userId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable UUID userId) {
		utenteService.findByIdAndDelete(userId);
	}

	// * * * * modifica controller per gestire endpoint aggiornamento password
	@PatchMapping("/{userId}/password")
	public ResponseEntity<String> updatePassword(@PathVariable UUID userId, @RequestBody String newPassword) {
		try {
			utenteService.updatePassword(userId, newPassword);
			return ResponseEntity.ok("Password aggiornata con successo.");
		} catch (ItemNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	// * * * *

}
