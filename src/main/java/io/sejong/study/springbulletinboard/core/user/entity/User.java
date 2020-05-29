package io.sejong.study.springbulletinboard.core.user.entity;

import io.sejong.study.springbulletinboard.core.user.http.req.UpdateUserReq;
import io.sejong.study.springbulletinboard.core.user.model.UserAuthorityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userNickname;
    private String userEmail;
    private String userPassword;
    @Enumerated(EnumType.STRING)
    private UserAuthorityType userAuthorityType;
    @Column(insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public User update(UpdateUserReq request) {
        this.userNickname = request.getUserNickname();
        this.userPassword = request.getUserPassword();
        return this;
    }
}
