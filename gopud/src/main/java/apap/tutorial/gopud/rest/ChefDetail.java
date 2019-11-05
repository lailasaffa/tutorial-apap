package apap.tutorial.gopud.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChefDetail {
    @JsonProperty("nama")
    private String nama;

    @JsonProperty("spesialis")
    private String spesialis;

    @JsonProperty("experience_in_years")
    private int experience;

    @JsonProperty("menus")
    private List<MenuDetail> menus;

}
