package gov.ssa.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
public class MvcConfigure extends WebMvcConfigurerAdapter{

	@Bean
	public SpringTemplateEngine getTemplateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		//templateEngine.setTemplateResolver(getTemplateResolver());
		Set<SpringResourceTemplateResolver> resolvers = new HashSet<SpringResourceTemplateResolver>();
		resolvers.add(getRootTemplateResolver());
		resolvers.add(getStudentTemplateResolver());
		resolvers.add(getMajorTemplateResolver());
		
		templateEngine.setTemplateResolvers(resolvers);
				
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver getViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();			
		resolver.setTemplateEngine(getTemplateEngine());
		return resolver;
	}

	@Bean
	public SpringResourceTemplateResolver getRootTemplateResolver() {

		SpringResourceTemplateResolver rootTemplateResolver = new SpringResourceTemplateResolver();

		rootTemplateResolver.setPrefix("/WEB-INF/View/");
		rootTemplateResolver.setSuffix(".html");
		rootTemplateResolver.setTemplateMode("HTML5");
		rootTemplateResolver.setCacheable(false);
		return rootTemplateResolver;
	}
	
	@Bean
	public SpringResourceTemplateResolver getStudentTemplateResolver() {

		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

		templateResolver.setPrefix("/WEB-INF/View/students/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	@Bean
	public SpringResourceTemplateResolver getMajorTemplateResolver() {

		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

		templateResolver.setPrefix("/WEB-INF/View/majors/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
}

