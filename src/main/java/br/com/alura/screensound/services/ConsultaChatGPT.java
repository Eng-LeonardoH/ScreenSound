package br.com.alura.screensound.services;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterResposta(String texto) {
        OpenAiService service = new OpenAiService("Token-API");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Simule que você é o artista que vou passar, quero que faça uma breve apresentação sobre quem é, onde nasceu, os principais marcos da sua história e quais seus principais sucessos: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}