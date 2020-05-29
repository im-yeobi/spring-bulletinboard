package io.sejong.study.springbulletinboard.core.user.http.req;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateUserReq {
    private Long userId;
    private String userNickname;
    private String userPassword;
}
