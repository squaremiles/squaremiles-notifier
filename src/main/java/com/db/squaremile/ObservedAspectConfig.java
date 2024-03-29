package com.db.squaremile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@Configuration
@EnableAspectJAutoProxy
public class ObservedAspectConfig {

	@Bean
	public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		observationRegistry.observationConfig().observationHandler(new LogObservationHandler());
		return new ObservedAspect(observationRegistry);
	}

	/*
	 * @Bean public TimedAspect timedAspect(MeterRegistry registry) { return new
	 * TimedAspect(registry); }
	 */

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/*
	 * @Bean
	 * 
	 * @ConditionalOnClass(name = "io.opentelemetry.javaagent.OpenTelemetryAgent")
	 * public MeterRegistry otelRegistry() { Optional<MeterRegistry> otelRegistry =
	 * Metrics.globalRegistry.getRegistries().stream() .filter(r ->
	 * r.getClass().getName().contains("OpenTelemetryMeterRegistry")) .findAny();
	 * otelRegistry.ifPresent(Metrics.globalRegistry::remove); return
	 * otelRegistry.orElse(null); }
	 */
}
