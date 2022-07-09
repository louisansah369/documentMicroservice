package com.example.documentservice.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentservice.model.Attachment;
import com.example.documentservice.model.Document;
import com.example.documentservice.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	public Document saveDocument(Document document) {
		document.setCreatedDate(LocalDateTime.now());
		document.setUpdatedDate(LocalDateTime.now());
		document.setDocumentfile((getAttachment(document)));//.getFile());
		document.setDocumentName(getAttachment(document).getFileName());
		document.setDocumentExtention(getAttachment(document).getFileExtension());
		return documentRepository.save(document);
	}
	
	public Optional<Document> findDocumentById(long id) {
		return documentRepository.findById(id);
	}
	
	public Document updateDocument(Document updatedDocument, Document retrievedDocument) {
			retrievedDocument.setDocumentType(updatedDocument.getDocumentType());
			retrievedDocument.setDocumentName(getAttachment(updatedDocument).getFileName());
			retrievedDocument.setDocumentExtention(getAttachment(updatedDocument).getFileExtension());
			retrievedDocument.setDocumentExtention(getAttachment(updatedDocument).getFileName());
			retrievedDocument.setUpdatedDate(LocalDateTime.now());
			return documentRepository.save(retrievedDocument);
	}
	
	public List<Document> getUserDocuments(Long id){
		return documentRepository.findByUserId(id);
	}
	
	/*public Optional<String> getExtensionByStringHandling(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}*/
	
	private Attachment getAttachment(Document document){
		Attachment _attachment = new Attachment();
		String fileName = document.getFile().getOriginalFilename();
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if(i > 0) {  //
			extension = fileName.substring(i + 1);
		}
		_attachment.setFileName(fileName);
		_attachment.setFileExtension(extension);
		document.setFile(document.getFile());
		
		return _attachment;
		
	}
}
