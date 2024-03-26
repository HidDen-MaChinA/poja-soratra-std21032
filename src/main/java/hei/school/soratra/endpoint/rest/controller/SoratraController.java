package hei.school.soratra.endpoint.rest.controller;

import hei.school.soratra.endpoint.rest.controller.client.GetSoratra;
import hei.school.soratra.service.SoratraService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SoratraController {
    private final SoratraService service;

    @PutMapping("/soratra/{id}")
    public String saveSoratra(@PathVariable String id, @RequestBody String soratra){
        return service.saveSoratra(id, soratra);
    }
    @GetMapping("/soratra/{id}")
    public GetSoratra getSoratra(@PathVariable String id){
        return service.getSoratra(id);
    }
}
