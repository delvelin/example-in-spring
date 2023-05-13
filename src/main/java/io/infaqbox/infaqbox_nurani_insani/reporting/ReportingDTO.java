package io.infaqbox.infaqbox_nurani_insani.reporting;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReportingDTO {

    private Long id;
    private Integer tglD;
    private Integer tglM;
    private Integer tglY;
    private Long time;
    private Integer boxId;
    private Long userId;

}
