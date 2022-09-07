package co.cookies.api;

import co.cookies.model.cookie.CookieType;
import co.cookies.usecase.allcookietype.AllCookieTypeUseCase;
import co.cookies.usecase.cookietypebyid.CookieTypeByCodeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class Handler {

    private final Logger logger = Logger.getLogger("logger");
    private  final CookieTypeByCodeUseCase cookieTypeByCodeUseCase;
    private  final AllCookieTypeUseCase allCookieTypeUseCase;
    public Mono<ServerResponse> listenGETUseCase() {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allCookieTypeUseCase.getAll(), CookieType.class)
                .onErrorResume(e->ServerResponse.badRequest().bodyValue(""));
    }

    public Mono<ServerResponse> listenGETByCodeUseCase(ServerRequest serverRequest) {
        String codeStr = serverRequest.pathVariable("code");
        Integer code = Integer.valueOf(codeStr);

        return cookieTypeByCodeUseCase.getCookieType(code)
                .flatMap(cookieType -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(cookieType), CookieType.class))
                .onErrorResume(e -> {
                    logger.warning(e.getMessage().concat(" code:").concat(codeStr));
                    return ServerResponse.badRequest().bodyValue("Code not Found");
                });

    }
}
