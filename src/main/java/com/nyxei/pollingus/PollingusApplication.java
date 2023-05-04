package com.nyxei.pollingus;

import com.nyxei.pollingus.controllers.Digester;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PollingusApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PollingusApplication.class, args);
		//f
		Digester.readMd("markdown-syntax/yes-no-question.md");
		Digester.readMd("markdown-syntax/affiliate-question.md");
		Parser parser = Parser.builder().build();
		Node document = parser.parse("This is *Sparta*");
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		renderer.render(document);
	}

}

