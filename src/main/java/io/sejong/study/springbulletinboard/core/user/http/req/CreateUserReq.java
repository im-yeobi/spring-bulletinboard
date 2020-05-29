package io.sejong.study.springbulletinboard.core.user.http.req;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CreateUserReq {
    private String userNickname;
    private String userEmail;
    private String userPassword;
}
