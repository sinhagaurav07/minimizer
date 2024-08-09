package in.co.moi.minimizer;

import org.springframework.boot.SpringApplication;

import in.co.moi.minimizer.app.MinimizerApplication;

public class TestMinimizerApplication {

	public static void main(String[] args) {
		SpringApplication.from(MinimizerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
