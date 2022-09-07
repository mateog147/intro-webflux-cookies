package co.cookies.mockrepository;

import co.cookies.model.cookie.CookieType;
import co.cookies.model.cookie.gateways.CookieTypeRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Repository
public class MockRepository implements CookieTypeRepository {

    private List<CookieType> list = Arrays.asList(
                    CookieType.builder().code(1).type("Stroopwafel").build(),
                    CookieType.builder().code(2).type("Chocolate Chip").build()
            );

    @Override
    public Flux<CookieType> findAll() {
        return Flux.fromIterable(list);
    }
}
