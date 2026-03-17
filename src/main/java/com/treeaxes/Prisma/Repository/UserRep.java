package com.treeaxes.Prisma.Repository;

import com.treeaxes.Prisma.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);
}
