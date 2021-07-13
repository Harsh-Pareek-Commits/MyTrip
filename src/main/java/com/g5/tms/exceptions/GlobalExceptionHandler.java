package com.g5.tms.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public ResponseEntity<MyExceptionResponse> handleCustomerException(CustomerNotFoundException ex) {
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
			}

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleBookingException(BookingNotFoundException ex) {
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<MyExceptionResponse> invalidSeedId(InvalidCredentialException ex) {

    	MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(PackageNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handlePackageException(PackageNotFoundException ex) {
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ReportNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleReportException(ReportNotFoundException ex) {
		
		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleRouteException(RouteNotFoundException ex) {

		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleFeedbackException(FeedbackNotFoundException ex) {

		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(TravelsNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleTravelsException(TravelsNotFoundException ex) {

		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<MyExceptionResponse> handleTHotelException(HotelNotFoundException ex) {

		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.NOT_FOUND.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionResponse> handleRouteException(Exception ex) {

		MyExceptionResponse exeResponse = new MyExceptionResponse();
		exeResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		exeResponse.setMessage(ex.getMessage());
		return new ResponseEntity<MyExceptionResponse>(exeResponse,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
		
		//fieldName,errorMsg
		Map<String,List<String>> map = new HashMap<>();
		List<String> myerrors=new ArrayList<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			myerrors.add( fieldName+" : "+error.getDefaultMessage());
			
			
		});
		map.put("message",myerrors);
		
	return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
