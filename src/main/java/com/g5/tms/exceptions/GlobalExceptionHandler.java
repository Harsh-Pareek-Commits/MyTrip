package com.g5.tms.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerException(CustomerNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get customer");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<String> handleBookingException(BookingNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get booking");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> handleInavalidCredentialException(InvalidCredentialException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Authorization faild");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}

	@ExceptionHandler(PackageNotFoundException.class)
	public ResponseEntity<String> handlePackageException(PackageNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get package");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}

	@ExceptionHandler(ReportNotFoundException.class)
	public ResponseEntity<String> handleReportException(ReportNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get report");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<String> handleRouteException(RouteNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get route");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<String> handleFeedbackException(FeedbackNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get feedback");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	@ExceptionHandler(TravelsNotFoundException.class)
	public ResponseEntity<String> handleTravelsException(TravelsNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get travels");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}

}
