package guru.springframework.sfgbreweryapi.controller;

import guru.springframework.sfgbreweryapi.model.Beer;
import guru.springframework.sfgbreweryapi.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
@Slf4j
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        log.debug("Getting beer by id in controller: {}", id);

        return beerService.getBeerById(id);
    }

}
