package com.example.Unit02Week03Day01.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DispositivoPayload {

	protected String tipo;
	protected String stato;
	protected String codice;

}
