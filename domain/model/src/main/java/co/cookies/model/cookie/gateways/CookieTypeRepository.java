package co.cookies.model.cookie.gateways;

import co.cookies.model.cookie.CookieType;
import reactor.core.publisher.Flux;

public interface CookieTypeRepository {
    Flux<CookieType> findAll();
}
