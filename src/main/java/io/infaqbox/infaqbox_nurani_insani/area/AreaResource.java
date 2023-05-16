package io.infaqbox.infaqbox_nurani_insani.area;

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
@RequestMapping(value = "/api/areas", produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaResource {

    private final AreaService areaService;

    public AreaResource(final AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public ResponseEntity<List<AreaDTO>> getAllAreas() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> getArea(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(areaService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createArea(@RequestBody @Valid final AreaDTO areaDTO) {
        final Long createdId = areaService.create(areaDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateArea(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final AreaDTO areaDTO) {
        areaService.update(id, areaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteArea(@PathVariable(name = "id") final Long id) {
        areaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
