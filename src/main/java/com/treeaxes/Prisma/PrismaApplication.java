package com.treeaxes.prisma;

import com.treeaxes.prisma.Persistence.Entity.PermissionEntity;
import com.treeaxes.prisma.Persistence.Entity.RoleEntity;
import com.treeaxes.prisma.Persistence.Entity.RoleEnum;
import com.treeaxes.prisma.Persistence.Entity.UserEntity;
import com.treeaxes.prisma.Persistence.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Permission;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PrismaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrismaApplication.class, args);
    }


    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            /* CREATE PERMISSIONS */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();


            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();


            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();


            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();


            // Create Roles

            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionsList(Set.of(createPermission,readPermission,updatePermission))
                    .build();


            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionsList(Set.of(createPermission,readPermission,updatePermission,deletePermission,refactorPermission))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionsList(Set.of(createPermission,readPermission))
                    .build();


            /* Create Users */

            UserEntity userAkomi = UserEntity.builder()
                    .username("Akomi")
                    .password(passwordEncoder.encode("longaniza"))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();


            UserEntity userRafa = UserEntity.builder()
                    .username("rafa")
                    .password(passwordEncoder.encode("1234"))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();


            UserEntity userDev = UserEntity.builder()
                    .username("developer")
                    .password(passwordEncoder.encode("devtool"))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialsNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();


            userRepository.saveAll(List.of(userAkomi,userRafa,userDev));
        };




    }

}
