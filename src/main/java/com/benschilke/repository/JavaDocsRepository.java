package com.benschilke.repository;

import org.springframework.data.repository.CrudRepository;

import com.benschilke.model.JavaDoc;
import java.lang.String;
import java.util.List;

public interface JavaDocsRepository extends CrudRepository<JavaDoc, Long>{
	
	List<JavaDoc> findByTerm(String term);
	
	List<JavaDoc> findByTermContaining(String term);

}
