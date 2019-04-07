package me.psalguero.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class StudentApplication {

  private static final Logger LOG = LoggerFactory.getLogger(StudentApplication.class);

  public static void main(String[] args) throws UnknownHostException {
    SpringApplication application = new SpringApplication(StudentApplication.class);
    Environment env = application.run(args).getEnvironment();

    LOG.warn(
        "\n----------------------------------------------------------\n\t"
            + "Application '{}' is running! Access URLs:\n\t"
            + "Local: \t\thttp://localhost:{}\n\t"
            + "External: \thttp://{}:{}\n\t"
            + "Profile(s): \t{}\n----------------------------------------------------------",
        env.getProperty("application.name"),
        env.getProperty("server.port"),
        InetAddress.getLocalHost().getHostAddress(),
        env.getProperty("server.port"),
        env.getActiveProfiles()
    );

  }

}
