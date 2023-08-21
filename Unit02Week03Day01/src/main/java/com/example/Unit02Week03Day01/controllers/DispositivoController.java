package com.example.Unit02Week03Day01.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Unit02Week03Day01.entities.Dispositivo;
import com.example.Unit02Week03Day01.entities.DispositivoPayload;
import com.example.Unit02Week03Day01.services.DispositivoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

	private final DispositivoService dispositivoService;

	@Autowired
	public DispositivoController(DispositivoService dispositivoService) {
		this.dispositivoService = dispositivoService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivo saveDevice(@RequestBody DispositivoPayload body) {
		Dispositivo created = dispositivoService.save(body);
		return created;
	}

	@GetMapping("")
	public List<Dispositivo> getDevices() {
		return dispositivoService.findAll();
	}

	@GetMapping("/{deviceId}")
	public Dispositivo getDeviceById(@PathVariable UUID deviceId) {
		return dispositivoService.findById(deviceId);

	}

	@PutMapping("/{deviceId}")
	public Dispositivo updateDevice(@PathVariable UUID deviceId, @RequestBody DispositivoPayload body) {
		return dispositivoService.findByIdAndUpdate(deviceId, body);
	}

	@DeleteMapping("/{deviceId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDevice(@PathVariable UUID deviceId) {
		dispositivoService.findByIdAndDelete(deviceId);
	}

}
