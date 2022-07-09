package com.example.documentservice.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@SuppressWarnings("unused")
@Data
@Entity
@Table(name = "document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NonNull
	private long userId;
	
	@NonNull
	private String documentType;
	
	@Transient
	@NonNull	
	private MultipartFile file;
	
	@Lob
	private Attachment documentfile;
	
	
	private String documentName;
	private String documentExtention;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	/**
	 * @return the documentExtention
	 */
	public String getDocumentExtention() {
		return documentExtention;
	}
	

	/**
	 * @param documentExtention the documentExtention to set
	 */
	public void setDocumentExtention(String documentExtention) {
		this.documentExtention = documentExtention;
	}
	
	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}
	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the updatedDate
	 */
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	/**
	 * @return the documentfile
	 */
	public Attachment getDocumentfile() {
		return documentfile;
	}


	/**
	 * @param attachment the documentfile to set
	 */
	public void setDocumentfile(Attachment attachment) {
		this.documentfile = attachment;
	}


	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}


	/**
	 * @param multipartFile the file to set
	 */
	public void setFile(MultipartFile multipartFile) {
		this.file = multipartFile;
	}


	/**
	 * @return the documentType
	 */
	public String getDocumentType() {
		return documentType;
	}


	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	
}
