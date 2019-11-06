package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.rest.ResultDetail;
import apap.tutorial.gopud.service.RecipesRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class RecipesRestController {
    @Autowired
    private RecipesRestService recipesRestService;
    @GetMapping("/recipe")
    private Mono<ResultDetail> getRecipes(
            @RequestParam(value = "namaBahan") String namaBahan){
        return recipesRestService.getRecipes(namaBahan,"german");
    }

}
