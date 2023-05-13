package io.infaqbox.infaqbox_nurani_insani.box;

import io.infaqbox.infaqbox_nurani_insani.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class BoxService {

    private final BoxRepository boxRepository;

    public BoxService(final BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public List<BoxDTO> findAll() {
        final List<Box> boxs = boxRepository.findAll(Sort.by("id"));
        return boxs.stream()
                .map((box) -> mapToDTO(box, new BoxDTO()))
                .toList();
    }

    public BoxDTO get(final Long id) {
        return boxRepository.findById(id)
                .map(box -> mapToDTO(box, new BoxDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final BoxDTO boxDTO) {
        final Box box = new Box();
        mapToEntity(boxDTO, box);
        return boxRepository.save(box).getId();
    }

    public void update(final Long id, final BoxDTO boxDTO) {
        final Box box = boxRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(boxDTO, box);
        boxRepository.save(box);
    }

    public void delete(final Long id) {
        boxRepository.deleteById(id);
    }

    private BoxDTO mapToDTO(final Box box, final BoxDTO boxDTO) {
        boxDTO.setId(box.getId());
        boxDTO.setNomor(box.getNomor());
        boxDTO.setIdArea(box.getIdArea());
        boxDTO.setNamaTempat(box.getNamaTempat());
        boxDTO.setAlamat(box.getAlamat());
        boxDTO.setPhone(box.getPhone());
        boxDTO.setCp(box.getCp());
        return boxDTO;
    }

    private Box mapToEntity(final BoxDTO boxDTO, final Box box) {
        box.setNomor(boxDTO.getNomor());
        box.setIdArea(boxDTO.getIdArea());
        box.setNamaTempat(boxDTO.getNamaTempat());
        box.setAlamat(boxDTO.getAlamat());
        box.setPhone(boxDTO.getPhone());
        box.setCp(boxDTO.getCp());
        return box;
    }

}
