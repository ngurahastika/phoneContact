package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Kontak;
import com.example.repository.KontakRepository;

@Service
public class KontakService {
	@Autowired
	KontakRepository kontakRepository;

	public Kontak create(Kontak kontak) {
		return kontakRepository.save(kontak);
	}

	public Kontak update(Kontak kontak, Long id) {
		getById(id);
		kontak.setId(id);
		return kontakRepository.save(kontak);

	}

	public Kontak delete(Long id) {
		Kontak kontakId = getById(id);

		kontakRepository.deleteById(id);

		return kontakId;
	}

	public Kontak getById(Long id) {
		return kontakRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id tidak ditemukan"));
	}

	public List<Kontak> getAllKontak() {
		return kontakRepository.findAll();
	}
	
//	public List<Kontak> getByName(String nama){
//		return kontakRepository.findByName(nama);
//	}
}
