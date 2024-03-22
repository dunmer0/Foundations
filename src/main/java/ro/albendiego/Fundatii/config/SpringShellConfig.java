package ro.albendiego.Fundatii.config;

import org.jline.reader.LineReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import ro.albendiego.Fundatii.utils.InputReader;


@Configuration
@ComponentScan("ro.albendiego.Fundatii")
public class SpringShellConfig {
    @Bean
    public InputReader inputReader(@Lazy LineReader lineReader) {
        return new InputReader(lineReader);
    }
}
