package io.sejong.study.springbulletinboard.core.user.helper;

import io.sejong.study.springbulletinboard.core.user.entity.User;
import io.sejong.study.springbulletinboard.core.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserHelper {

    private final UserRepository userRepository;

    public UserHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User upsertUser(User user) {
        return userRepository.save(user);
    }

    public Page<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
