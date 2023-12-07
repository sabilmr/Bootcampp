package com.bootcsmp.securitydemo.service;

import com.bootcsmp.securitydemo.dto.UserDto;
import com.bootcsmp.securitydemo.entity.RoleEntity;
import com.bootcsmp.securitydemo.entity.UserEntity;
import com.bootcsmp.securitydemo.repository.RoleRepo;
import com.bootcsmp.securitydemo.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserEntity> getById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public Optional<UserEntity> save(UserDto request) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(request, entity);

        entity.setId(UUID.randomUUID().toString());

        Optional<RoleEntity> role = roleRepo.findByName(request.getRole());
        role.ifPresent(roleEntity -> entity.setRoles(Arrays.asList(roleEntity)));

        entity.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            userRepo.save(entity);
            log.info("Update user is success");
            return Optional.of(entity);
        }catch (Exception e){
            log.error("Update user is failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> update(String id, UserDto request) {
        if (id == null || id.isEmpty()){
            return Optional.empty();
        }
        UserEntity entity = this.userRepo.findById(id).orElse(null);
        if (entity == null){
            return Optional.empty();
        }
        BeanUtils.copyProperties(request, entity);

        Optional<RoleEntity> role = roleRepo.findByName(request.getRole());
        role.ifPresent(roleEntity -> entity.setRoles(Arrays.asList(roleEntity)));

        entity.setPassword(passwordEncoder.encode(request.getPassword()));

        try {
            userRepo.save(entity);
            log.info("Update user is success");
            return Optional.of(entity);
        } catch (Exception e){
            log.error("Update user is failed, error : {}",e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserEntity> delete(String id) {
        return Optional.empty();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
