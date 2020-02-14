package com.david.littleairbook.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.david.littleairbook.jpa.Record;
import com.david.littleairbook.service.RecordService;

@RestController
@RequestMapping("/api/record")
public class RecordController {

	@Autowired
	private RecordService service;
	
	@GetMapping("/list")
	public List<Record> getList(@RequestParam(value = "name", defaultValue = "2020-02") String month) {
		System.out.println("XXXX");
		return service.findAll();
	}
}
