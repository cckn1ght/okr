package io.qunhao.okr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		OkrApplication.class,
		Jsr310JpaConverters.class
})
public class OkrApplication {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
	}

	public static void main(String[] args) {
		SpringApplication.run(OkrApplication.class, args);
	}

}
