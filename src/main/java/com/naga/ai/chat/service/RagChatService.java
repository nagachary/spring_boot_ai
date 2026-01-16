package com.naga.ai.chat.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

@Service
public class RagChatService {

    private final RetrievalService retrievalService;
    private final ChatModel chatModel;

    public RagChatService(RetrievalService retrievalService, ChatModel chatModel) {
        this.retrievalService = retrievalService;
        this.chatModel = chatModel; // Injected OpenAI chat model
    }

    public String generateAnswer(String question) {
        // Step 1: Retrieve relevant document
        String doc = retrievalService.retrieve(question);
        if (doc == null || doc.isEmpty()) {
            return "No relevant document found.";
        }

        // Step 2: Construct prompt
        String combinedPrompt = "You are an AI assistant. Use the following document to answer the question.\n\n"
                + "Document: " + doc + "\n\nQuestion: " + question;

        // Step 3: Create Prompt object and call ChatModel
        Prompt prompt  = Prompt.builder().build();
        prompt.augmentUserMessage(combinedPrompt);

        // Step 4: Get the response
        return chatModel.call(prompt)
                .getResult()
                .getOutput().getText();
    }
}
