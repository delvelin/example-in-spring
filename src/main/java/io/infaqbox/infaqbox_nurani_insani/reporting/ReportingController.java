package io.infaqbox.infaqbox_nurani_insani.reporting;

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
@RequestMapping(value = "/api/reportings", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportingController {

    private final ReportingService reportingService;

    public ReportingController(final ReportingService reportingService) {
        this.reportingService = reportingService;
    }

    @GetMapping
    public ResponseEntity<List<ReportingDTO>> getAllReportings() {
        return ResponseEntity.ok(reportingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportingDTO> getReporting(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(reportingService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createReporting(
            @RequestBody @Valid final ReportingDTO reportingDTO) {
        final Long createdId = reportingService.create(reportingDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReporting(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final ReportingDTO reportingDTO) {
        reportingService.update(id, reportingDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteReporting(@PathVariable(name = "id") final Long id) {
        reportingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
