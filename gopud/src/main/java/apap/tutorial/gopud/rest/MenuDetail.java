package apap.tutorial.gopud.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDetail {
    @JsonProperty("nama")
    private String nama;

    @JsonProperty("harga")
    private int harga;

    @JsonProperty("durasi_masak")
    private int durasiMasak;

    @JsonProperty("deskripsi")
    private String deskripsi;
}
