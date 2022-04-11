package example.demomaven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
public class Controller {
    @GetMapping(value = "/hello")
    public Map<String, String> listAllHeaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }
}
