package co.cookies.usecase.cookietypebyid;

import co.cookies.model.cookie.CookieType;
import co.cookies.model.cookie.gateways.CookieTypeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CookieTypeByCodeUseCase {
    private final CookieTypeRepository repository;

    public Mono<CookieType> getCookieType(Integer code){
        return repository.findAll()
                .filter(cookieType -> cookieType.getCode().equals(code))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Error: Item not Found")))
                .next()
                .onErrorResume(Mono::error);
    }
}
