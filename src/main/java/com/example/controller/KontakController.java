package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Kontak;
import com.example.service.KontakService;

@RestController
@RequestMapping("/kontak")
public class KontakController {
	@Autowired
	KontakService kontakService;

	@PostMapping
	public ResponseEntity<Kontak> create(@RequestBody Kontak kontak) {
		return new ResponseEntity(kontakService.create(kontak), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Kontak> update(@PathVariable Long id, @RequestBody Kontak kontak) {
		return new ResponseEntity(kontakService.update(kontak, id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Kontak> delete(@PathVariable Long id) {
		return new ResponseEntity(kontakService.delete(id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Kontak> getById(@PathVariable Long id) {
		return new ResponseEntity(kontakService.getById(id), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Kontak> getAllKontak() {
		return new ResponseEntity(kontakService.getAllKontak(), HttpStatus.OK);
	}

}
