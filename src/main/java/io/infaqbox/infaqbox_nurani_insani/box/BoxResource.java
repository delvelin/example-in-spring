package io.infaqbox.infaqbox_nurani_insani.box;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/boxs", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoxResource {

    private final BoxService boxService;

    public BoxResource(final BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public ResponseEntity<List<BoxDTO>> getAllBoxs() {
        return ResponseEntity.ok(boxService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxDTO> getBox(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(boxService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createBox(@RequestBody @Valid final BoxDTO boxDTO) {
        final Long createdId = boxService.create(boxDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBox(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final BoxDTO boxDTO) {
        boxService.update(id, boxDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteBox(@PathVariable(name = "id") final Long id) {
        boxService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
