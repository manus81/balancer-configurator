package com.nicepeople.balancer.configurator.application.controller.exception;

import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nicepeople.balancer.configurator.application.exception.ApplicationException;
import com.nicepeople.balancer.configurator.domain.exception.DomainException;
import com.nicepeople.balancer.configurator.domain.exception.NotFoundException;

@ControllerAdvice
public class ControllerHandlerException {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerHandlerException.class);

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<HttpErrorResponse> handleGenericException(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);

		final HttpErrorResponse errorResponse = new HttpErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// TODO especificar jerarquias ApplicationException DomainException
	@ExceptionHandler({ ApplicationException.class, DomainException.class })
	public ResponseEntity<HttpErrorResponse> handleConflictException(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);

		final HttpErrorResponse errorResponse = new HttpErrorResponse(HttpStatus.CONFLICT.value(),
				HttpStatus.CONFLICT.getReasonPhrase(), exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
	}

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<HttpErrorResponse> handleNotFoundException(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);

		final HttpErrorResponse errorResponse = new HttpErrorResponse(HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ ValidationException.class })
	public ResponseEntity<HttpErrorResponse> handleValidationException(final Exception exception) {
		LOGGER.error(exception.getMessage(), exception);

		final HttpErrorResponse errorResponse = new HttpErrorResponse(HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.getReasonPhrase(), exception.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
