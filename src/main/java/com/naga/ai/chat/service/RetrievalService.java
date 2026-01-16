package com.naga.ai.chat.service;

import com.naga.ai.chat.utils.CosineSimilarityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievalService {
    private final DocumentLoaderService documentLoaderService;
    private final EmbeddingService embeddingService;

    public RetrievalService(DocumentLoaderService documentLoaderService, EmbeddingService embeddingService) {
        this.documentLoaderService = documentLoaderService;
        this.embeddingService = embeddingService;
    }

    public String retrieve(String query) {
        float[] queryEmbedding = embeddingService.getEmbedding(query);

        List<float[]> docEmbeddings = documentLoaderService.getEmbeddings();
        List<String> documents = documentLoaderService.getDocuments();

        double maxSim = -1;
        int bestIndex = -1;

        for (int i = 0; i < docEmbeddings.size(); i++) {
            double sim = CosineSimilarityUtil.cosineSimilarity(queryEmbedding, docEmbeddings.get(i));
            if (sim > maxSim) {
                maxSim = sim;
                bestIndex = i;
            }
        }

        return bestIndex != -1 ? documents.get(bestIndex) : null;
    }
}
