package com.bootcsmp.securitydemo.config;

import com.bootcsmp.securitydemo.entity.ProductEntity;
import com.bootcsmp.securitydemo.entity.RoleEntity;
import com.bootcsmp.securitydemo.entity.UserEntity;
import com.bootcsmp.securitydemo.repository.ProductRepo;
import com.bootcsmp.securitydemo.repository.RoleRepo;
import com.bootcsmp.securitydemo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;
import java.util.PrimitiveIterator;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit implements CommandLineRunner {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ProductRepo productRepo;


    @Override
    public void run(String... args) throws Exception {
        iniUserAndrole();

        iniProduct();;
    }
    private void iniUserAndrole(){
        if (roleRepo.findAll().isEmpty()){
            try {
                roleRepo.saveAll(
                        Arrays.asList(
                                new RoleEntity(UUID.randomUUID().toString(),"ROLE_USER"),
                                new RoleEntity(UUID.randomUUID().toString(),"ROLE_ADMIN"),
                                new RoleEntity(UUID.randomUUID().toString(),"ROLE_SUPER_USER")
                        )
                );
                log.info("Save role is success");
            }catch (Exception e){
                log.info("Save role is failed, error : {}",e.getMessage());
            }
        }
        if (userRepo.findAll().isEmpty()){
            Optional<RoleEntity> suRole = roleRepo.findByName("ROLE_SUPER_USER");
            if (suRole.isPresent()){
                userRepo.save(new UserEntity(UUID.randomUUID().toString(), "Super User","super.user@gmail.com",
                        passwordEncoder.encode("P@ssW0rd"),Arrays.asList(suRole.get())));
            }
            Optional<RoleEntity> userRole = roleRepo.findByName("ROLE_USER");
            userRole.ifPresent(roleEntity -> userRepo.save(new UserEntity(UUID.randomUUID().toString(), "User", "user@gmail.com",
                    passwordEncoder.encode("P@ssW0rd"), Arrays.asList(roleEntity))));

            Optional<RoleEntity> adminRole = roleRepo.findByName("ROLE_ADMIN");
            adminRole.ifPresent(roleEntity -> userRepo.save(new UserEntity(UUID.randomUUID().toString(), "Admin", "admin@gmail.com",
                    passwordEncoder.encode("P@ssW0rd"), Arrays.asList(roleEntity))));
        }
    }
    private void iniProduct(){
        if (productRepo.findAll().isEmpty()){
            productRepo.saveAll(Arrays.asList(
                    new ProductEntity(UUID.randomUUID().toString(),"P001","Nasi Goreng",15000.0,100.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P002","Nasi Pecel",10000.0,150.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P003","Bakso Urat + Daging",20000.0,200.0),
                    new ProductEntity(UUID.randomUUID().toString(),"P004","Ayam Geprek",25000.0,250.0)
            ));
        }
    }
}
