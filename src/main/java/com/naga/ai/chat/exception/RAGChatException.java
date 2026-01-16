package com.naga.ai.chat.exception;


public class RAGChatException extends Exception {

  private final ErrorResponse errorResponse;

  public RAGChatException(ErrorResponse errorResponse) {
    super(errorResponse.errorMessage());
    this.errorResponse = errorResponse;
  }

  public String getErrorMessage() {
    return errorResponse.errorMessage();
  }

  public String getErrorCode() {
    return errorResponse.errorCode();
  }

  public ErrorResponse getErrorResponse() {
    return errorResponse;
  }
}
