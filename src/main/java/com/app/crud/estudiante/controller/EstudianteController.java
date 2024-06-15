package com.app.crud.estudiante.controller;

import java.util.List;

import javax.validation.Valid;

import com.app.crud.estudiante.controller.dto.EstudianteRequest;
import com.app.crud.estudiante.controller.dto.EstudianteResponse;
import com.app.crud.estudiante.exception.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.estudiante.mapper.EstudianteMapper;
import com.app.crud.estudiante.service.EstudianteService;
import com.app.crud.estudiante.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(Constants.URL_BASE)
@Tag(name = "Estudiante", description = "Estudiante API")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private EstudianteMapper estudianteMapper;

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = EstudianteResponse.class))
					)
			}, description = "Obtiene todos los estudiantes.")
		}
	)
	@Operation(summary = "Listar Todos")
	@GetMapping
	public List<EstudianteResponse> listar() {
		log.info("call listar()");

		return estudianteMapper.estudiantesToEstudianteResponseList(estudianteService.obtenerEstudiantes());
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Operación exitosa." ,content = {
					@Content(mediaType = "application/json",
							examples = @ExampleObject(value = "{\n" +
									"    \"id\": 1,\n" +
									"    \"nombre\": \"Yahir\",\n" +
									"    \"apellido\": \"Rivas\",\n" +
									"    \"email\": \"yahir.rivas@gmail.com\",\n" +
									"    \"creditos\": \"5\",\n" +
									"    \"semestre\": \"2\",\n" +
									"    \"promedio\": \"5\"\n" +
									"}" ))
			}),
			@ApiResponse(responseCode = "400", description = "#1 Response 400 | Valida si existe correo en la base de datos. <br/> {\"mensaje\":\"El correo ya registrado.\"} <br/> <br/>",
					content = @Content(mediaType = "application/json"))
		}
	)
	@Operation(summary = "Crear Estudiante")
	@PostMapping
	public ResponseEntity<Object> crear(@Valid @RequestBody
												 @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
												 content = {
														 @Content(mediaType = "application/json",
																 schema = @Schema(implementation = EstudianteRequest.class),
																 examples = @ExampleObject(value = "{\n" +
																		 "    \"nombre\": \"Yahir\",\n" +
																		 "    \"apellido\": \"Rivas\",\n" +
																		 "    \"email\": \"yahir.rivas@gmail.com\",\n" +
																		 "    \"creditos\": \"5\",\n" +
																		 "    \"semestre\": \"2\",\n" +
																		 "    \"promedio\": \"5\"\n" +
																		 "}"))
												 })
									   EstudianteRequest estudianteRequest) {
		log.info("call crear()");
		
		EstudianteResponse estudianteResponse =
				estudianteMapper.estudianteServiceDtoToEstudianteResponse(
				estudianteService.crear(estudianteMapper.estudianteRequestToEstudianteServiceDto(estudianteRequest)));

		return ResponseEntity.status(HttpStatus.CREATED).body(estudianteResponse);
	}


	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación exitosa." ,content = {
					@Content(mediaType = "application/json",
							examples = @ExampleObject(value ="{\n" +
									"    \"id\": 1,\n" +
									"    \"nombre\": \"Yahir\",\n" +
									"    \"apellido\": \"Rivas\",\n" +
									"    \"email\": \"yahir.rivas@gmail.com\",\n" +
									"    \"creditos\": \"5\",\n" +
									"    \"semestre\": \"2\",\n" +
									"    \"promedio\": \"5\"\n" +
									"}" ))
			}),
			@ApiResponse(responseCode = "400", description = "#1 Response 400 | Valida si existe correo en la base de datos. <br/> {\"mensaje\":\"El correo ya registrado.\"} <br/> <br/>",
					content = @Content(mediaType = "application/json"))
	}
	)
	@Operation(summary = "Actualizar Estudiante")
	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizar(@Valid @RequestBody
									   @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
											   content = {
													   @Content(mediaType = "application/json",
															   schema = @Schema(implementation = EstudianteRequest.class),
															   examples = @ExampleObject(value = "{\n" +
																	   "    \"nombre\": \"Yahir\",\n" +
																	   "    \"apellido\": \"Rivas\",\n" +
																	   "    \"email\": \"yahir.rivas@gmail.com\",\n" +
																	   "    \"creditos\": \"5\",\n" +
																	   "    \"semestre\": \"2\",\n" +
																	   "    \"promedio\": \"5\"\n" +
																	   "}"))
											   })
									   EstudianteRequest estudianteRequest,
											 @Parameter(required = true, description = "id") @PathVariable Integer id) {
		log.info("call actualizar()");

		estudianteRequest.setId(id);

		EstudianteResponse estudianteResponse = estudianteMapper.estudianteServiceDtoToEstudianteResponse(
				estudianteService.crear(estudianteMapper.estudianteRequestToEstudianteServiceDto(estudianteRequest)));

		return ResponseEntity.status(HttpStatus.OK).body(estudianteResponse);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación exitosa." ,content = {
					@Content(mediaType = "application/json",
							examples = @ExampleObject(value = "{\n" +
									"    \"id\": 1,\n" +
									"    \"nombre\": \"Yahir\",\n" +
									"    \"apellido\": \"Rivas\",\n" +
									"    \"email\": \"yahir.rivas@gmail.com\",\n" +
									"    \"creditos\": \"5\",\n" +
									"    \"semestre\": \"2\",\n" +
									"    \"promedio\": \"5\"\n" +
									"}" ))
			}),
		}
	)
	@Operation(summary = "Obtener Estudiante")
	@GetMapping("/{id}")
	public ResponseEntity<EstudianteResponse> obtenerEstudiante(@Parameter(required = true, description = "id") @PathVariable Integer id) {
		log.info("call obtenerEstudiante()");

		EstudianteResponse estudianteResponse = estudianteMapper.estudianteServiceDtoToEstudianteResponse(
				estudianteService.obtenerEstudianteById(id));

		return ResponseEntity.status(HttpStatus.OK).body(estudianteResponse);
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación exitosa.")
		}
	)
	@Operation(summary = "Eliminar Estudiante")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@Parameter(required = true, description = "id") @PathVariable Integer id) {
		log.info("call eliminar()");

		MessageResponse.MessageResponseBuilder mssageResponse = MessageResponse.builder();

		boolean resultado = estudianteService.eliminar(id);

		if (resultado) {
			mssageResponse.message("Se eliminó correctamente");
		}

		return ResponseEntity.status(HttpStatus.OK).body(mssageResponse.build());
	}
}
