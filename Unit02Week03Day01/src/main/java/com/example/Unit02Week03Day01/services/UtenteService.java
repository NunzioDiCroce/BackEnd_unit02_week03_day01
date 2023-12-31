package com.example.Unit02Week03Day01.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Unit02Week03Day01.entities.Utente;
import com.example.Unit02Week03Day01.exceptions.BadRequestException;
import com.example.Unit02Week03Day01.exceptions.ItemNotFoundException;
import com.example.Unit02Week03Day01.exceptions.NotFoundException;
import com.example.Unit02Week03Day01.payloads.UserRequestPayload;
import com.example.Unit02Week03Day01.payloads.UtentePayload;
import com.example.Unit02Week03Day01.repositories.UtenteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtenteService {

	private final UtenteRepository utenteRepository;

	@Autowired
	public UtenteService(UtenteRepository utenteRepository) {
		this.utenteRepository = utenteRepository;
	}

	// create utente usata in AuthController
	public Utente create(UserRequestPayload body) {
		utenteRepository.findByMail(body.getMail()).ifPresent(user -> {
			throw new BadRequestException("L'email è già stata utilizzata");
		});
		Utente newUser = new Utente(body.getNome(), body.getCognome(), body.getMail(), body.getPassword());
		return utenteRepository.save(newUser);
	}

	// save utente
	public void save(Utente utente) {
		utenteRepository.save(utente);
		log.info("Utente con ID " + utente.getId() + " salvato con successo");

	}

	// save by UtentePayload
	public Utente save(UtentePayload body) {
		Utente nuovoUtente = new Utente(body.getUserName(), body.getNome(), body.getCognome(), body.getMail());
		return utenteRepository.save(nuovoUtente);
	}

	public List<Utente> findAll() {
		return utenteRepository.findAll();
	}

	public Utente findById(UUID id) throws ItemNotFoundException {
		return utenteRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

	}

	// findByEmail usato in AuthController
	public Utente findByEmail(String mail) {
		return utenteRepository.findByMail(mail)
				.orElseThrow(() -> new NotFoundException("Utente con email" + mail + "non trovato"));
	}

	public Utente findByIdAndUpdate(UUID id, UtentePayload body) throws ItemNotFoundException {
		Utente found = this.findById(id);

		found.setNome(body.getNome());
		found.setCognome(body.getCognome());
		found.setMail(body.getMail());

		return utenteRepository.save(found);
	}

	public void findByIdAndDelete(UUID id) throws ItemNotFoundException {
		Utente found = this.findById(id);
		utenteRepository.delete(found);
	}

}
