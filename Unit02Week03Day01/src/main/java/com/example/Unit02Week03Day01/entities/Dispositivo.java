package com.example.Unit02Week03Day01.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Builder
public class Dispositivo {

	@Id
	@GeneratedValue
	private UUID id;

	protected String tipo;
	protected String stato;
	protected String codice;

	@ManyToOne
	protected Utente utente;

	public Dispositivo(String tipo, String stato, String codice) {
		this.tipo = tipo;
		this.stato = stato;
		this.codice = codice;
	}

}
