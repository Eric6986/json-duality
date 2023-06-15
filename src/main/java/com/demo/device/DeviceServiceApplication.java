package com.demo.device;

import com.demo.device.repository.student_documentsRepository;
import com.demo.device.repository.student_scheduleRepository;
import com.demo.device.repository.teacher_scheduleRepository;
import com.spring4all.mongodb.EnableMongoPlus;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableJpaRepositories(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = student_documentsRepository.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = student_scheduleRepository.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = teacher_scheduleRepository.class)
}
)
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Device API", version = "1.0", description = "Device Information"))
@EnableMongoPlus
@EnableMongoRepositories
public class DeviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceServiceApplication.class, args);
	}

}
