package hello.servelet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 서블릿 객체 자동 탐색 하여 등록
@SpringBootApplication
public class ServeletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServeletApplication.class, args);
	}

}
