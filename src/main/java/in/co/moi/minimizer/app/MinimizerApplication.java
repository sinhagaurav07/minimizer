package in.co.moi.minimizer.app;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.actuate.autoconfigure.cassandra.CassandraHealthContributorAutoConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "in.co.moi.*" })
//@EnableAutoConfiguration(exclude={CassandraDataAutoConfiguration.class, CassandraHealthContributorAutoConfiguration.class})
@EnableCassandraRepositories(basePackages = { "in.co.moi.minimizer.data.repository" })
public class MinimizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinimizerApplication.class, args);
	}

}
