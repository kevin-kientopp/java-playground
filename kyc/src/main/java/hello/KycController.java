package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class KycController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${sphonic.port}")
    private int sphonicPort;

    @RequestMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
      RestTemplate restTemplate = new RestTemplate();
      Greeting greeting = restTemplate.getForObject("http://localhost:" + sphonicPort + "/greeting?name=Kevin", Greeting.class);
        return greeting;
    }
}
