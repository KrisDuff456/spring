package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContainer {
	@RequestMapping("/")
	public String index() {
		return "Hello World, this is Spring Boot";
	}

}
