package com.udea.ordermpc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Demo API",
				version = "1.0",
				description = "Ejemplo de API con OpenAPI en ruta personalizada"
		)
)
public class OrdermpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermpcApplication.class, args);
	}

}
