package co.cookies.model.cookie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CookieType {
    private Integer code;
    private String type;
}
