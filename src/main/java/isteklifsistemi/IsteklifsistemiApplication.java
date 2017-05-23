package isteklifsistemi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IsteklifsistemiApplication {

    private static final Logger logger = LoggerFactory.getLogger(IsteklifsistemiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IsteklifsistemiApplication.class, args);
	}

//	@Bean
//    CommandLineRunner runner(TalepRepository repository) {
//        return (args) -> {
//            TalepMapper t1 = new TalepMapper();
//            t1.setTitle("t1");
//            t1 = repository.save(t1);
//            System.out.println(t1.getId());
//        };
//    }
}
