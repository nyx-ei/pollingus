package com.nyxei.pollingus;

import com.nyxei.pollingus.controllers.Digester;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import static com.nyxei.pollingus.controllers.WebhookController.envoitemplate;

@SpringBootApplication
public class PollingusApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(PollingusApplication.class, args);
		//f
		Digester.lectureMd("markdown-syntax/yes-no-question.md");
		Digester.lectureMd("markdown-syntax/affiliate-question.md");
		Parser parser = Parser.builder().build();
		Node document = parser.parse("This is *Sparta*");
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		renderer.render(document);
	}

}

