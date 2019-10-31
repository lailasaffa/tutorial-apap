package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.ResultDetail;
import reactor.core.publisher.Mono;

public interface RecipesRestService {
    Mono<ResultDetail> getRecipes(String excludeIngredient, String cuisine);
}
