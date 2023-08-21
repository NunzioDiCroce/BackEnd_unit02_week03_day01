package com.example.Unit02Week03Day01.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestPayload {

	private String nome;
	private String cognome;
	private String mail;
	private String password;

}
