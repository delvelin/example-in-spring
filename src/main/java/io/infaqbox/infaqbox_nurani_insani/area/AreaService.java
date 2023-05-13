package io.infaqbox.infaqbox_nurani_insani.area;

import io.infaqbox.infaqbox_nurani_insani.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AreaService {

    private final AreaRepository areaRepository;

    public AreaService(final AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public List<AreaDTO> findAll() {
        final List<Area> areas = areaRepository.findAll(Sort.by("id"));
        return areas.stream()
                .map((area) -> mapToDTO(area, new AreaDTO()))
                .toList();
    }

    public AreaDTO get(final Long id) {
        return areaRepository.findById(id)
                .map(area -> mapToDTO(area, new AreaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AreaDTO areaDTO) {
        final Area area = new Area();
        mapToEntity(areaDTO, area);
        return areaRepository.save(area).getId();
    }

    public void update(final Long id, final AreaDTO areaDTO) {
        final Area area = areaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(areaDTO, area);
        areaRepository.save(area);
    }

    public void delete(final Long id) {
        areaRepository.deleteById(id);
    }

    private AreaDTO mapToDTO(final Area area, final AreaDTO areaDTO) {
        areaDTO.setId(area.getId());
        areaDTO.setNamaArea(area.getNamaArea());
        return areaDTO;
    }

    private Area mapToEntity(final AreaDTO areaDTO, final Area area) {
        area.setNamaArea(areaDTO.getNamaArea());
        return area;
    }

}
