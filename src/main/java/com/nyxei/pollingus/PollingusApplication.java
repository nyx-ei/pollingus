package com.nyxei.pollingus;

import com.nyxei.pollingus.controllers.Digester;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PollingusApplication {

	public static void main(String[] args) {
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

