package com.example.documentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.documentservice.model.Document;
import com.example.documentservice.service.DocumentService;

@RestController
@RequestMapping("/api")
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	@PostMapping("/document")
	public ResponseEntity<Document> createDocument(@RequestBody Document document){
		try {
			Document _document = documentService.saveDocument(document);
			return new ResponseEntity<>(_document, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/document/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable("id") long id,@RequestBody Document document){
		Optional<Document> userDocument = documentService.findDocumentById(id);
		if(userDocument.isPresent()) {
			Document retrievedDocument = userDocument.get();
			Document persistedDocument = documentService.updateDocument(document, retrievedDocument);
			return new ResponseEntity<>(persistedDocument, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/document/download/{id}")
	public ResponseEntity<byte[]> downloadDocument(@PathVariable("id") long id) {
		Optional<Document> userDocument = documentService.findDocumentById(id);
		if(userDocument.isPresent()) {
			return new ResponseEntity<byte[]>(null);
			//(userDocument.get().get, null)
			//return new ResponseEntity<byte[]>(userDocument.get().getFile(),null);
					//<>(userDocument, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/document/{id}")
	public ResponseEntity<List<Document>> getUserDocuments(Long userId){
		List<Document> userDocument = documentService.getUserDocuments(userId);
		if(userDocument.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(userDocument, HttpStatus.OK);
		}
	}
}
