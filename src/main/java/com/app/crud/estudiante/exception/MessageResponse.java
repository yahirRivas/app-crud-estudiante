package com.app.crud.estudiante.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(value = Include.NON_NULL)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

	 @JsonProperty("mensaje")
	 private Object message;

	 private List<Field> fields;
	
	 @Builder
	 @Data
	 @NoArgsConstructor
	 @AllArgsConstructor
	 public static class Field {
		
		private String name;
		private String message;
	}
}
