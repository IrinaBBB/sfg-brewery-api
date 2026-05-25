package guru.springframework.sfgbreweryapi.services;

import guru.springframework.sfgbreweryapi.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> getAllBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
