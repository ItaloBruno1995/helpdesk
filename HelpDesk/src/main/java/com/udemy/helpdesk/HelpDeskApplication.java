

package com.udemy.helpdesk;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.udemy.helpdesk.api.entidade.Usuario;
import com.udemy.helpdesk.api.perfil.PerfilEnum;
import com.udemy.helpdesk.api.repository.UsuarioRepositorio;




@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}
	
   @Bean
   CommandLineRunner init(UsuarioRepositorio userRepository, PasswordEncoder passwordEncoder) {
       return args -> {
           initUsers(userRepository, passwordEncoder);
       };

   }
   
	private void initUsers(UsuarioRepositorio userRepository, PasswordEncoder passwordEncoder) {
       Usuario admin = new Usuario();
       admin.setEmail("admin@helpdesk.com");
       admin.setSenha(passwordEncoder.encode("123456"));
       admin.setPerfil(PerfilEnum.FUNC_ADIM);

       Usuario find = userRepository.findByEmail("admin@helpdesk.com");
       if (find == null) {
           userRepository.save(admin);
       }
   }
}