package com.example.demo.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User not found")
        );
        UserDetails userDetails = new User(userDB.getUsername(),
            userDB.getPassword(),
            mapRolesToAuthorities(userDB.getRoles()));

        return userDetails;
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity saveAdmin(Admin admin){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(admin.getUsuario());
        userEntity.setPassword(passwordEncoder.encode(admin.getContrasena()));

        Role roles = roleRepository.findByName("ADMIN").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    public UserEntity saveCliente(Cliente cliente){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(cliente.getCedula()));
        userEntity.setPassword(null); // Codificar la contraseña

        Role roles = roleRepository.findByName("CLIENTE").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }

    public UserEntity saveVet(Veterinario vet){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(vet.getCedula()));
        userEntity.setPassword(passwordEncoder.encode(vet.getContrasena()));

        Role roles = roleRepository.findByName("VET").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
}