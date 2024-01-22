package com.db.squaremile.service;

import org.springframework.stereotype.Service;

import com.db.squaremile.dto.PropertyDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationService {
	
	
	//@Observed(name = "send.notification.for.property.service", lowCardinalityKeyValues = {"send.notification", "send.notification"})
	public String sendNotification(PropertyDto propertyDto) {
		/*
		 * return propertyDto.flatMap(it->{
		 * log.info("Info level {} ",it.getPropertyId()); return Mono.just("SUCCESS");
		 * });
		 */
		return "success";
		
	}

}
