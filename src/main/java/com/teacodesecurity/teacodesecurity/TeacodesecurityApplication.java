package com.teacodesecurity.teacodesecurity;

import com.teacodesecurity.teacodesecurity.model.Role;
import com.teacodesecurity.teacodesecurity.model.UserModel;
import com.teacodesecurity.teacodesecurity.repository.RoleRespitory;
import com.teacodesecurity.teacodesecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class TeacodesecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacodesecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RoleRespitory roleRespitory, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if(roleRespitory.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRespitory.save(new Role(UUID.randomUUID(),"ADMIN"));
			roleRespitory.save(new Role(UUID.randomUUID(),"USER"));

			Set<Role> roles = new HashSet<>();

			roles.add(adminRole);

			UserModel admin = new UserModel(UUID.randomUUID(),"admin","admin","kwamekyeimonies@001",
					passwordEncoder.encode("password"),roles);

			userRepository.save(admin);
		};
	}

}
