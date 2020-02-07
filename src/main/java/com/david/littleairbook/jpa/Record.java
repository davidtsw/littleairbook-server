package com.david.littleairbook.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Record {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String passportNumber;
}
