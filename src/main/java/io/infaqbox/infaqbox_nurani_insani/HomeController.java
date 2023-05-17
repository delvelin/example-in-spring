package io.infaqbox.infaqbox_nurani_insani;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Bismillah. Laporan Infaq Box Nuari Insani";
    }

}
