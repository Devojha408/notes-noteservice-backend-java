package com.pdg.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pdg.note.dao.NoteRepository;
import com.pdg.note.model.Note;

@CrossOrigin(origins="*")
@RestController
public class NoteController {

	@Autowired
	NoteRepository noteRepository;
	
	@GetMapping("/notes")
	public List<Note> getAll() {
		System.out.println("all notes");
		return this.noteRepository.findAll();
	}
	
	@GetMapping("/notes/{user_id}")
	public List<Note> balanceAmount(@PathVariable int user_id) {
		return this.noteRepository.findByUserId(user_id);
	}
	
	@PostMapping("/notes")
	public Note addAccount(@RequestBody Note n) {
		return this.noteRepository.save(n);
	}
	
	@PutMapping("/update")
	public boolean updateNote(@RequestBody Note n) {
		this.noteRepository.save(n);
		System.out.println("Note updated! "+ n.toString());
		return true;
	}
	
	@DeleteMapping("/delete/{note_id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable String note_id){
		try {
			this.noteRepository.deleteById(Integer.parseInt(note_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
