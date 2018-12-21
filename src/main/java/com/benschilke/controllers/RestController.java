package com.benschilke.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.benschilke.model.JavaDoc;
import com.benschilke.repository.JavaDocsRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	JavaDocsRepository javaDocsRepository;
	
	@RequestMapping("/search")
	public List<JavaDoc> search(@RequestParam("term") String term) {
		List<JavaDoc> javaDocs = javaDocsRepository.findByTerm(term);
		return javaDocs;
	}
	
	/*

	@RequestMapping("/search")
	public List<JavaDoc> search(@RequestParam("term") String term) {
		List<JavaDoc> javaDocs = new ArrayList<>();
		javaDocsRepository.findAll()
				.forEach(j -> javaDocs.add(j));
		int count = javaDocs.size();
		return javaDocs;
	}

	 */

}
