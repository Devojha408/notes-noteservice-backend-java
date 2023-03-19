package com.pdg.note.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pdg.note.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer>{
	
	@Query("SELECT n from note n where n.user_id=?1")
	List<Note> findByUserId(int user_id);
}
