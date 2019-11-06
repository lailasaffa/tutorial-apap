package apap.tutorial.gopud.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDetail {
    @JsonProperty("results")
    private List<RecipesDetail> detailRecipe;

    public List<RecipesDetail> getDetailRecipe() {
        return detailRecipe;
    }

    public void setDetailRecipe(List<RecipesDetail> detailRecipe) {
        this.detailRecipe = detailRecipe;
    }
}
