package com.example.Unit02Week03Day01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Unit02Week03Day01.entities.Utente;
import com.example.Unit02Week03Day01.services.UtenteService;

@RestController
@RequestMapping("/autorizzazione")
public class AuthController {

	@Autowired
	UtenteService utenteService;

	@Autowired
	JWTTools jwtTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UserRequestPayload body) {
		Utente created = utenteService.create(body);

		return created;
	}

}
