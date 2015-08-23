package de.hamburg.marcel.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.hamburg.marcel.springboot.application.Application;
import io.github.robwin.markup.builder.MarkupLanguage;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
public class Swagger2MarkupTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void convertSwaggerBusinessAPIToAsciiDoc() throws Exception {
		this.mockMvc.perform(get("/v2/api-docs?group=business-api").accept(MediaType.APPLICATION_JSON)).andDo(print());

		this.mockMvc.perform(get("/v2/api-docs?group=business-api").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/asciidoc/generated").build())
				.andExpect(status().isOk());
	}

	@Test
	public void convertSwaggerBusinessAPIToMarkdown() throws Exception {
		this.mockMvc.perform(get("/v2/api-docs?group=business-api").accept(MediaType.APPLICATION_JSON))
				.andDo(Swagger2MarkupResultHandler.outputDirectory("src/docs/markdown/generated")
						.withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
				.andExpect(status().isOk());
	}
}