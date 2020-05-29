package io.sejong.study.springbulletinboard.core.user.repository;

import io.sejong.study.springbulletinboard.core.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(Long userId);
}
