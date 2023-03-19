package com.pdg.note.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

@Component
@Table(name="note")
@Entity(name="note")
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noteId;
	
	private String title;
	
	private String text;
	
	private int user_id;
	
	@Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime timestamp;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", text=" + text + ", user_id=" + user_id
				+ ", timestamp=" + timestamp + "]";
	}
    
    

}
