package com.example.Unit02Week03Day01.entities;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.Unit02Week03Day01.enums.Ruolo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private UUID id;

	protected String nome;
	protected String cognome;

	@Column(nullable = false, unique = true)
	protected String mail;

	private String password;

	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;

	@OneToMany
	protected Set<Dispositivo> dispositivi;

	public Utente(String nome, String cognome, String mail, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.password = password;
		this.ruolo = Ruolo.USER;
	}

//	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(ruolo.name()));
	}

//	@Override
	public String getUsername() {
		return this.mail;
	}

//	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

//	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

//	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

//	@Override
	public boolean isEnabled() {
		return true;
	}

}
