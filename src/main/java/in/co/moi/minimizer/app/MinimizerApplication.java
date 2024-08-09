package in.co.moi.minimizer.app;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.actuate.autoconfigure.cassandra.CassandraHealthContributorAutoConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"in.co.moi.*"})
//@EnableAutoConfiguration(exclude={CassandraDataAutoConfiguration.class, CassandraHealthContributorAutoConfiguration.class})
public class MinimizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinimizerApplication.class, args);
	}

}
