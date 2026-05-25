package guru.springframework.sfgbreweryapi.services;

import guru.springframework.sfgbreweryapi.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
