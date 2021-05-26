package com.g5.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.g5.tms.service.IFeedbackService;

@RestController
public class FeedbackController {
	@Autowired
IFeedbackService feedback_service;
}
