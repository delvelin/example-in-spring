package io.infaqbox.infaqbox_nurani_insani.reporting;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReportingDTO {

    private Long id;

    @NotNull
    private Long time;

    @NotNull
    private Integer boxId;

    @NotNull
    private Long userId;

    @NotNull
    private Double jumlah;


}
