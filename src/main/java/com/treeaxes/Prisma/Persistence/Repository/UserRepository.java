package com.treeaxes.prisma.Persistence.Repository;


import com.treeaxes.prisma.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);


//    @Query("SELECT u FROM UserEntity WHERE u.username = ?")
//    Optional<UserEntity> findUser(String username);
}
