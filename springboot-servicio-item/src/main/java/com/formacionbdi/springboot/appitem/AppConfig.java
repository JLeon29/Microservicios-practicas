package com.formacionbdi.springboot.appitem;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // Permite crear objetos, componentes de spring
public class AppConfig {
	
	/*RestTemplate: Es un cliente para trabajar con ApiRest, cliente HTTP , 
	para poder acceder al recurso que estan en otros microservicios*/
	@Bean("clienteRest") // para que se guarde en el contenedor con ese nombre
	@LoadBalanced // Para el balanceo de carga con Restemplate- Ribbon
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate(); 
	}

}
