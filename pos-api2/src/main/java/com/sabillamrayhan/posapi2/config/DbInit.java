package com.sabillamrayhan.posapi2.config;

import com.sabillamrayhan.posapi2.entity.RoleEntity;
import com.sabillamrayhan.posapi2.entity.UserEntity;
import com.sabillamrayhan.posapi2.repository.RoleRepo;
import com.sabillamrayhan.posapi2.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        iniRoleAndUser();
    }
    public void iniRoleAndUser(){
        if (roleRepo.findAll().isEmpty()){
            try {
                roleRepo.saveAll(List.of(
                        new RoleEntity("ROLE_ADMIN"),
                        new RoleEntity("ROLE_USER"),
                        new RoleEntity("ROLE_SUPER_USER")
                ));
                log.info("Save role success..!");
            }catch (Exception e){
                log.error("Save role is failed, error : {}",e.getMessage());
            }
        }
        if(userRepo.findAll().isEmpty()){
            RoleEntity adminRole = roleRepo.findByName("ROLE_ADMIN").orElse(null);
            if (adminRole != null){
                UserEntity admin = new UserEntity("Admin","User","admin@gmail.com", passwordEncoder.encode("P@ssW0rd32!"),List.of(adminRole));
                try {
                    userRepo.save(admin);
                    log.info("Create admin role success..!");
                }catch (Exception e){
                    log.error("Save role failed, error : {}",e.getMessage());
                }
            }

            RoleEntity userRole = roleRepo.findByName("ROLE_USER").orElse(null);
            if (adminRole != null){
                UserEntity user = new UserEntity("User","Role","user@gmail.com",passwordEncoder.encode("P@ssW0rd32!"),List.of(userRole));
                try {
                    userRepo.save(user);
                    log.info("Create user role success..!");
                }catch (Exception e){
                    log.error("Create user role failed, Error : {}",e.getMessage());
                }
            }

            RoleEntity superRole = roleRepo.findByName("ROLE_SUPER_USER").orElse(null);
            if (superRole != null){
                UserEntity superUser = new UserEntity("Super","User","super.user@gmail,com", passwordEncoder.encode("P@ssW0rd32!"),List.of(superRole));
                try {
                    userRepo.save(superUser);
                    log.info("Create super user role success..!");
                }catch (Exception e){
                    log.error("Create super user role failed, Error: {}",e.getMessage());
                }
            }
        }
    }
}
