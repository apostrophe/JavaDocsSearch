package com.benschilke.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.benschilke.model.JavaDoc;
import com.benschilke.repository.JavaDocsRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	JavaDocsRepository javaDocsRepository;
	
	// localhost/search?term=Array
	@RequestMapping("/search")
	public List<JavaDoc> search(@RequestParam("term") String term) {
		System.out.println("term:"+term);
		List<JavaDoc> javaDocs = javaDocsRepository.findByTermContainingIgnoreCase(term);
		javaDocs.stream().forEach(jd -> jd.setPath("https://docs.oracle.com/javase/8/docs/api/"+jd.getPath()));
		return javaDocs;
	}
	
	// localhost/suggest?term=list
	@RequestMapping(value="/suggest")
	public String suggest(@RequestParam("term") String term) {

		List<JavaDoc> javaDocs = javaDocsRepository.findTop10ByTermContainingIgnoreCase(term);
//		System.out.printf("term: %s, count: %d%n", term, javaDocs.size());
		
		StringBuilder suggestions = new StringBuilder();
		javaDocs.stream().map(j -> j.getTerm()).forEach(j -> suggestions.append(j));
		return suggestions.toString();
	
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
