package com.g5.tms.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
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
	public ResponseEntity<String> handleInvalidCredentialException(InvalidCredentialException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Authorization failed");
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
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleRouteException(Exception ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("Description", "Trying to get date");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
		
		//fieldName,errorMsg
		Map<String,String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName = ((FieldError)error).getField();
			String msg = error.getDefaultMessage();
			
			map.put(fieldName,msg);
		});
		
		
	return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
