package com.naga.ai.chat.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentLoaderService {
    private final EmbeddingService embeddingService;

    private final List<String> documents = new ArrayList<>();
    private final List<float[]> embeddings = new ArrayList<>();

    public DocumentLoaderService(EmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    public void addDocument(String text) {
        documents.add(text);
        embeddings.add(embeddingService.getEmbedding(text));
    }

    public List<String> getDocuments() {
        return documents;
    }

    public List<float[]> getEmbeddings() {
        return embeddings;
    }

    public List<String> loadDocuments() {
        return List.of(
                "Spring Boot is used to build REST APIs.",
                "RAG stands for Retrieval Augmented Generation.",
                "Spring AI integrates AI models into Spring applications.",
                "OpenAI provides GPT and embedding models."
        );
    }

}
