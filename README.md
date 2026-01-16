# RAG Supported Chat Application
This is the spring boot project which has integrations with  llm ai tools. 

* Add Document Endpoint (RAG) : 
 ```
curl -X POST http://localhost:8086/mysbaiapp/rag/add -d "Spring Boot is a Java framework for building web applications.
 ```
* Query Endpoint (Chat):

```
curl GET http://localhost:8086/mysbaiapp/rag/query?question="Tell me about AI models"
```

