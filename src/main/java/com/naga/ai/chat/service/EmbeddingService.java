package com.naga.ai.chat.service;

import org.springframework.stereotype.Service;
import org.springframework.ai.embedding.EmbeddingModel;

@Service
public class EmbeddingService {

    private final EmbeddingModel embeddingModel;

    public EmbeddingService(EmbeddingModel embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    public float[] getEmbedding(String text) {
        return embeddingModel.embed(text);
    }
}
