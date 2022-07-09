package com.example.documentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.documentservice.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	List<Document> findByUserId(Long userId);
//	Document findbyID(Long documentID);
}
