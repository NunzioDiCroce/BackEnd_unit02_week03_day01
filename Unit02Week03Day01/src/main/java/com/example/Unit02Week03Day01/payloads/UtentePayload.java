package com.example.Unit02Week03Day01.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UtentePayload {

	protected String userName;
	protected String nome;
	protected String cognome;
	protected String mail;

}
