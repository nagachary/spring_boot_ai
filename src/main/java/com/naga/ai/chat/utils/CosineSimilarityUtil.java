package com.naga.ai.chat.utils;

public class CosineSimilarityUtil {
    public static double cosineSimilarity(float[] v1, float[] v2) {
        if (v1.length != v2.length)
            throw new IllegalArgumentException("Vectors must be same length");
        double dot = 0.0, normA = 0.0, normB = 0.0;
        for (int i = 0; i < v1.length; i++) {
            dot += v1[i] * v2[i];
            normA += v1[i] * v1[i];
            normB += v2[i] * v2[i];
        }
        if (normA == 0 || normB == 0) return 0.0;
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
