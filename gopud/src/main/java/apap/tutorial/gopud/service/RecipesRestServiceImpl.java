package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.ResultDetail;
import apap.tutorial.gopud.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RecipesRestServiceImpl implements RecipesRestService{
    private final WebClient webClient;
    private String apiKey = "dd6eb429b0724fe9997f19884d024c9c";
    public RecipesRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipesUrl).build();
    }

    @Override
    public Mono<ResultDetail> getRecipes(String excludeIngredient, String cuisine) {
        return this.webClient.get().uri(uriBuilder -> uriBuilder.queryParam("excludeIngredients",excludeIngredient)
                .queryParam("cuisine",cuisine).queryParam("apiKey",apiKey).build())
                .retrieve().bodyToMono(ResultDetail.class);
    }
}
