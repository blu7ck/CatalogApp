package com.blu4ck.prs;

import com.blu4ck.prs.core.exceptions.BusinessException;
import com.blu4ck.prs.core.exceptions.ProblemDetails;
import com.blu4ck.prs.core.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){

		ProblemDetails problemDetails = new ProblemDetails();

		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){

		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();

		validationProblemDetails.setMessage("Validation Exception");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}
	@Bean
	public ModelMapper mapper(){
		return new ModelMapper();

	}
}
