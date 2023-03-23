package ar.com.besy.microservices.futbolmanagercore.configurations;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@PropertySource(value="classpath:messages.properties")
@ConfigurationProperties(prefix = "app")
@Configuration
@Data
public class AppConfiguration {
    //@Value("${app.name}")//Lo saca del properties que tiene ese nombre
    private String name;
    //@Value("${app.edition}")
    private String edition;
    //@Value("${app.year}")
    private Integer year;
    //@Value("${app.countries}")
    private String[] countries;

    @Value("Raphael")
    private String author;

    private List<String> languages;

}
