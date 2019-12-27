package br.com.omnifunding.dto;

import java.util.Calendar;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDTO {

	private String message;

	private Calendar time;

	private String from;

}
