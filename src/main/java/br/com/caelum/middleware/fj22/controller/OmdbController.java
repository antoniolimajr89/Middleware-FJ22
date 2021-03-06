package br.com.caelum.middleware.fj22.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by matheusbrandino on 6/9/17.
 */
@RestController
public class OmdbController {

    @GetMapping(value = "/movie", produces = "application/json")
    public String recebe(@RequestParam("title") String title) {

        RestTemplate template = new RestTemplate();
        String json = template.getForObject("http://www.omdbapi.com/?apikey=598ae671&t=" + title + "&r=json", String.class);

        return json;
    }
}
