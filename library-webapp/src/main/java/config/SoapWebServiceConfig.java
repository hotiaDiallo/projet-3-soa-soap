package config;

import config_const.Utils;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet > messageDispatcherServlet(ApplicationContext context) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(context);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/soapWS/*");
  }

  @Bean
  public XsdSchema librarySchema() {
    return new SimpleXsdSchema(new ClassPathResource("library.xsd"));
  }

  @Bean(name = "library")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {

    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    definition.setSchema(userSchema);
    definition.setLocationUri("/soapWS");
    definition.setPortTypeName(Utils.PORT_NAME);
    definition.setTargetNamespace(Utils.NAMESPACE_URI);
    return definition;
  }
}