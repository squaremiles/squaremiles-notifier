package com.db.squaremile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.squaremile.dto.PropertyDto;
import com.db.squaremile.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping(value="/notify",consumes = MediaType.APPLICATION_JSON_VALUE)
	//@Observed(name = "send.notification.for.property.controller", lowCardinalityKeyValues = {"send.notification", "send.notification"})
	public ResponseEntity<String> sendNotificationForProperty(@RequestBody PropertyDto proprtyDto) {
		log.info("notifier is getting called");
		return new ResponseEntity(notificationService.sendNotification(proprtyDto),HttpStatus.OK);
	}

}
