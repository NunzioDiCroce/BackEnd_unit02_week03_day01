package com.example.Unit02Week03Day01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Unit02Week03Day01.entities.Dispositivo;
import com.example.Unit02Week03Day01.entities.DispositivoPayload;
import com.example.Unit02Week03Day01.repositories.DispositivoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DispositivoService {

	private final DispositivoRepository dispositivoRepository;

	private final UtenteService utenteService;

	@Autowired
	public DispositivoService(DispositivoRepository dispositivoRepository, UtenteService utenteService) {
		this.dispositivoRepository = dispositivoRepository;
		this.utenteService = utenteService;
	}

	// save dispositivo
	public void save(Dispositivo dispositivo) {
		dispositivoRepository.save(dispositivo);
		log.info("Dispositivo con ID " + dispositivo.getId() + " salvato con successo");

	}

	// save by DispositivoPayload
	public Dispositivo save(DispositivoPayload body) {
		Dispositivo nuovoDispositivo = new Dispositivo(body.getTipo(), body.getStato(), body.getCodice());
		return dispositivoRepository.save(nuovoDispositivo);
	}

	public List<Dispositivo> findAll() {
		return dispositivoRepository.findAll();
	}

	public Dispositivo findById(long id) throws ItemNotFoundException {
		return dispositivoRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));

	}

	public Dispositivo findByIdAndUpdate(long id, DispositivoPayload body) throws ItemNotFoundException {
		Dispositivo found = this.findById(id);

		found.setTipoDispositivo(body.getTipoDispositivo());
		found.setStatoDispositivo(body.getStatoDispositivo());

		return dispositivoRepository.save(found);
	}

	public void findByIdAndDelete(long id) throws ItemNotFoundException {
		Dispositivo found = this.findById(id);
		dispositivoRepository.delete(found);
	}

}
