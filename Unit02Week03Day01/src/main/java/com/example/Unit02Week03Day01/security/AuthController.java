package com.example.Unit02Week03Day01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Unit02Week03Day01.entities.Utente;
import com.example.Unit02Week03Day01.exceptions.UnauthorizedException;
import com.example.Unit02Week03Day01.payloads.LoginSuccessfullPayload;
import com.example.Unit02Week03Day01.payloads.UserLoginPayload;
import com.example.Unit02Week03Day01.payloads.UserRequestPayload;
import com.example.Unit02Week03Day01.services.UtenteService;

@RestController
@RequestMapping("/autorizzazione")
public class AuthController {

	@Autowired
	UtenteService utenteService;

	@Autowired
	JWTTools jwtTools;

	@Autowired
	PasswordEncoder bcrypt;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UserRequestPayload body) {

		body.setPassword(bcrypt.encode(body.getPassword()));

		Utente created = utenteService.create(body);

		return created;
	}

	@PostMapping("/login")
	public LoginSuccessfullPayload login(@RequestBody UserLoginPayload body) {

		Utente user = utenteService.findByEmail(body.getMail());

		if (body.getPassword().equals(user.getPassword())) {

			String token = jwtTools.createToken(user);
			return new LoginSuccessfullPayload(token);

		} else {

			throw new UnauthorizedException("Credenziali non valide!");
		}
	}

}
