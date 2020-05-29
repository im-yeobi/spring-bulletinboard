package io.sejong.study.springbulletinboard.core.user.service;

import io.sejong.study.springbulletinboard.core.user.entity.User;
import io.sejong.study.springbulletinboard.core.user.helper.UserHelper;
import io.sejong.study.springbulletinboard.core.user.http.req.CreateUserReq;
import io.sejong.study.springbulletinboard.core.user.http.req.UpdateUserReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserHelper userHelper;

    public UserService(UserHelper userHelper) {
        this.userHelper = userHelper;
    }

    public void createUser(CreateUserReq request) {
        User user = User.builder()
                .userNickname(request.getUserNickname())
                .userEmail(request.getUserEmail())
                .userPassword(request.getUserPassword())
                .build();
        userHelper.upsertUser(user);
    }

    public void updateUser(UpdateUserReq request) {
        User user = userHelper.findByUserId(request.getUserId()).orElseThrow(RuntimeException::new);
        user.update(request);
        userHelper.upsertUser(user);
    }

    public Page<User> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("created_at").descending());
        return userHelper.findAllUser(pageable);
    }

    public User getUserByUserId(Long userId) {
        return userHelper.findByUserId(userId).orElseThrow(RuntimeException::new);
    }
}
