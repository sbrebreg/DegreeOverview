package services;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ServiceConfig extends ResourceConfig {
	public ServiceConfig() {
		packages("services");
        register(JacksonFeature.class);
	}
}
