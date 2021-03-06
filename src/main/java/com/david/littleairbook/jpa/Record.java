package com.david.littleairbook.jpa;

import java.time.LocalDateTime;

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
	
	private Long userId;
	
	private LocalDateTime datetime;
	
	private String type;
	
	private String remark;
}
