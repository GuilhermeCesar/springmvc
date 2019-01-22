package org.casadocodigo.loja.conf;

import org.casadocodigo.loja.controllers.HomeController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackageClasses = HomeController.class)
public class AppWebConfiguration {
}
