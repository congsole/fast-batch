package com.fastcampus.batch.repository.user;

import com.fastcampus.batch.repository.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;

import java.util.Map;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")

public class UserEntity extends BaseEntity {
    @Id
    private String userId;

    private String userName;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String phone;

    // json 형태로 저장되어 있는 문자열 데이터를 Map으로 매핑합니다.
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> meta;

    public String getUuid() {
        String uuid = null;
        if (meta.containsKey("uuid")) {
            uuid = String.valueOf(meta.get("uuid"));
        }
        return uuid;

    }
}