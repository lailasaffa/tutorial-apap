package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.rest.ChefDetail;
import apap.tutorial.gopud.service.ChefRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class ChefRestController {
    @Autowired
    private ChefRestService chefRestService;
    @GetMapping("/restoran/chef")
    private Mono<ChefDetail> getChef(@RequestParam(value = "nama") String nama){
        return chefRestService.getChef(nama);
    }
}
