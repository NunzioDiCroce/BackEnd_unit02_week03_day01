package com.example.Unit02Week03Day01.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Builder
public class Utente {

	@Id
	@GeneratedValue
	private long id;

	protected String userName;
	protected String nome;
	protected String cognome;
	protected String mail;

	@OneToMany
	protected Set<Dispositivo> dispositivi;

	public Utente(String userName, String nome, String cognome, String mail) {
		this.userName = userName;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
	}

}
