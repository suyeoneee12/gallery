package org.shopping.gallery.backend.repository;

import org.shopping.gallery.backend.entity.Member;
import org.shopping.gallery.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
