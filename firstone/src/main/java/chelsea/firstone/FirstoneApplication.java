package chelsea.firstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstoneApplication {

    public static void main(String[] args) {
     ConfigurableApplicationContext context = SpringApplication.run(FirstoneApplication.class, args);


     System.out.println("Everything's Ok bro!");

    }

}
