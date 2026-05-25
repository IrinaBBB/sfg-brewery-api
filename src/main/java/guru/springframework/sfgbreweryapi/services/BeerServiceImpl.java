package guru.springframework.sfgbreweryapi.services;

import guru.springframework.sfgbreweryapi.model.Beer;
import guru.springframework.sfgbreweryapi.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Getting beer by id: {}", id);

        return Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat IPA")
                .beerStyle(BeerStyle.LAGER)
                .upc("123456789012")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(123)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
