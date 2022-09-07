package co.cookies.usecase.allcookietype;

import co.cookies.model.cookie.CookieType;
import co.cookies.model.cookie.gateways.CookieTypeRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class AllCookieTypeUseCase {
    private final CookieTypeRepository repository;

    public Flux<CookieType> getAll(){
        return repository.findAll();
    }
}
