package com.example.Unit02Week03Day01.payloads;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NewUserResponsePayload {

	private UUID id;

}
