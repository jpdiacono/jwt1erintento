/*package com.example.proyIntegradorFinal.jwt;

import com.example.proyIntegradorFinal.model.Rol;
import com.example.proyIntegradorFinal.model.User;
import com.example.proyIntegradorFinal.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new User("Juan","Ju","hola@gmail.com",hashedPassword,Rol.ADMIN));
        userRepository.save(new User("Pablo","PA","hola2@gmail.com",hashedPassword2,Rol.USER));



    }
}
*/

package com.example.proyIntegradorFinal.jwt;

import com.example.proyIntegradorFinal.model.Rol;
import com.example.proyIntegradorFinal.model.User;
import com.example.proyIntegradorFinal.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        var usuarioUser = new User(null,"Juan","Ju","juan@gmail.com",new BCryptPasswordEncoder().encode("7777"), Rol.USER);

        usuarioRepository.save(usuarioUser);

        var usuarioAdmin = new User(null,"Pablo","Pa","pablo@gmail.com",new BCryptPasswordEncoder().encode("7778"), Rol.ADMIN);

        usuarioRepository.save(usuarioAdmin);



    }
}