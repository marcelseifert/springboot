package de.hamburg.marcel.springboot.application;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;

@Configuration
public class Swagger2Config {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("business-api").select().paths(paths()) // and
																											// by
																											// paths
				.build().apiInfo(apiInfo());// .securitySchemes(securitySchemes()).securityContext(securityContext());
	}

	// Here is an example where we select any api that matches one of these
	// paths
	private Predicate<String> paths() {
		return or(regex("/kunde.*"), regex("/greeting.*"));
	}

	/*
	 * @Bean public Docket greetingApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors
	 * .any()) .paths(PathSelectors.any()).build().pathMapping("/")
	 * .directModelSubstitute(LocalDate.class,
	 * String.class).genericModelSubstitutes(ResponseEntity.class)
	 * .alternateTypeRules(newRule( typeResolver.resolve(DeferredResult.class,
	 * typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
	 * typeResolver.resolve(WildcardType.class)))
	 * .useDefaultResponseMessages(false).apiInfo(apiInfo()).securitySchemes(
	 * newArrayList(apiKey()))
	 * .securityContexts(newArrayList(securityContext())).enableUrlTemplating(
	 * true); }
	 */

	private ApiKey apiKey() {
		return new ApiKey("mykey", "api_key", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*"))
				.build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("mykey", authorizationScopes));
	}

	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration("test-app-client-id", "test-app-realm", "test-app", "apiKey");
	}

	// @Bean
	// UiConfiguration uiConfig() {
	// return new UiConfiguration("validatorUrl");
	// }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SLOT Person API")
				.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum "
						+ "has been the industry's standard dummy text ever since the 1500s, when an unknown printer "
						+ "took a "
						+ "galley of type and scrambled it to make a type specimen book. It has survived not only five "
						+ "centuries, but also the leap into electronic typesetting, remaining essentially unchanged. "
						+ "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum "
						+ "passages, and more recently with desktop publishing software like Aldus PageMaker including "
						+ "versions of Lorem Ipsum.")
				// .termsOfServiceUrl("http://springfox.io")
				.contact("developer@swisslife.de")
				// .license("Apache License Version 2.0")
				// .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
				// .version("2.0")
				.build();
	}
}
