//Every java application has a main class which is here
package alatoo.kg.springmid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//the main class in the whole application
//we have SpringMidApplicationTests class in (test package --> java --> alatoo.kg.springmid --> SpringMidApplicationTests file)
public class SpringMidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMidApplication.class, args);
    }

}
