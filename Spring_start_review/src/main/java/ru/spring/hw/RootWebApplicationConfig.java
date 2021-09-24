package ru.spring.hw;
//1-ый уровень конфигурации
//Подключает бины
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.spring.prev.CartConfiguration;

@Configuration
@Import(CartConfiguration.class)
public class RootWebApplicationConfig implements WebMvcConfigurer {
}
