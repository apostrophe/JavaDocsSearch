package com.benschilke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
@Table(name="javadocs")
public class JavaDoc {

	@Id
	@Column(name="entryid")
	private long id;
	@Column
	private String term;
	@Column
	private String path;
	
	public JavaDoc(String term, String path) {
		this.term = term;
		this.path = path;
	}
	
}
