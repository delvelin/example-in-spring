package io.infaqbox.infaqbox_nurani_insani.reporting;

import io.infaqbox.infaqbox_nurani_insani.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ReportingService {

    private final ReportingRepository reportingRepository;

    public ReportingService(final ReportingRepository reportingRepository) {
        this.reportingRepository = reportingRepository;
    }

    public List<ReportingDTO> findAll() {
        final List<Reporting> reportings = reportingRepository.findAll(Sort.by("id"));
        return reportings.stream()
                .map((reporting) -> mapToDTO(reporting, new ReportingDTO()))
                .toList();
    }

    public ReportingDTO get(final Long id) {
        return reportingRepository.findById(id)
                .map(reporting -> mapToDTO(reporting, new ReportingDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ReportingDTO reportingDTO) {
        final Reporting reporting = new Reporting();
        mapToEntity(reportingDTO, reporting);
        return reportingRepository.save(reporting).getId();
    }

    public void update(final Long id, final ReportingDTO reportingDTO) {
        final Reporting reporting = reportingRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reportingDTO, reporting);
        reportingRepository.save(reporting);
    }

    public void delete(final Long id) {
        reportingRepository.deleteById(id);
    }

    private ReportingDTO mapToDTO(final Reporting reporting, final ReportingDTO reportingDTO) {
        reportingDTO.setId(reporting.getId());
        reportingDTO.setTime(reporting.getTime());
        reportingDTO.setBoxId(reporting.getBoxId());
        reportingDTO.setUserId(reporting.getUserId());
        reportingDTO.setJumlah(reporting.getJumlah());
        return reportingDTO;
    }

    private Reporting mapToEntity(final ReportingDTO reportingDTO, final Reporting reporting) {
        reporting.setTime(reportingDTO.getTime());
        reporting.setBoxId(reportingDTO.getBoxId());
        reporting.setUserId(reportingDTO.getUserId());
        reporting.setJumlah(reportingDTO.getJumlah());
        return reporting;
    }

}
