package co.cookies.mockrepository;

import co.cookies.model.cookie.CookieType;
import co.cookies.model.cookie.gateways.CookieTypeRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Repository
public class MockRepository implements CookieTypeRepository {

    private final List<CookieType> list = Arrays.asList(
                    CookieType.builder().code(1).type("Stroopwafel").build(),
                    CookieType.builder().code(2).type("Chocolate Chip").build(),
                    CookieType.builder().code(3).type("Macaroons").build(),
                    CookieType.builder().code(4).type("Oatmeal").build(),
                    CookieType.builder().code(5).type("Fortune cookie").build(),
                    CookieType.builder().code(6).type("Sugar").build(),
                    CookieType.builder().code(7).type("Fried cookie").build(),
                    CookieType.builder().code(8).type("Benne Wafer").build(),
                    CookieType.builder().code(9).type("Oreo").build(),
                    CookieType.builder().code(10).type("Peanut butter").build()
            );

    @Override
    public Flux<CookieType> findAll() {
        return Flux.fromIterable(list);
    }
}
