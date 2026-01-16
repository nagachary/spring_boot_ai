package com.naga.ai.chat.model;

import java.util.List;

public class DocumentChunk {

    private final String content;
    private final List<Double> embedding;

    public DocumentChunk(String content, List<Double> embedding) {
        this.content = content;
        this.embedding = embedding;
    }

    public String getContent() {
        return content;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }
}
