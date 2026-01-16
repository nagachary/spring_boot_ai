package com.naga.ai.chat.controller;

import com.naga.ai.RagChatApplication;
import com.naga.ai.chat.exception.ErrorResponse;
import com.naga.ai.chat.exception.RAGChatException;
import com.naga.ai.chat.service.DocumentLoaderService;
import com.naga.ai.chat.service.RagChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rag")
public class RagChatController {
    private static final Logger logger = LoggerFactory.getLogger(RagChatController.class);
    private final DocumentLoaderService documentLoaderService;
    private final RagChatService ragChatService;

    public RagChatController(DocumentLoaderService documentLoaderService,
                             RagChatService ragChatService) {
        this.documentLoaderService = documentLoaderService;
        this.ragChatService = ragChatService;
    }

    @PostMapping("/add")
    public String addDocument(@RequestBody String doc) {
        logger.info("addDocument api");
        documentLoaderService.addDocument(doc);
        return "Document added!";
    }

    @GetMapping("/query")
    public String query(@RequestParam String question) throws RAGChatException {
        logger.info("query api");
        try {
            return ragChatService.generateAnswer(question);
        } catch (Exception exp) {
            logger.error("query api error");
            String errorCode = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value());
            if (exp instanceof NonTransientAiException) {
                logger.error("query api NonTransientAiException error");
                errorCode = String.valueOf(HttpStatus.TOO_MANY_REQUESTS.value());
            }
            ErrorResponse errorResponse = new ErrorResponse(exp.getMessage(), errorCode);
            throw new RAGChatException(errorResponse);
        }
    }
}
