package om.disney.wdpro.otherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class OtherserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtherserviceApplication.class, args);
    }

}
