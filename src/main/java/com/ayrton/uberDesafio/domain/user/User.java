package com.ayrton.uberDesafio.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String fullName;
    private String username;
    private String email;
    private String phoneNumber;

    private Role role;
    private UserSex userSex;
    private int numberRaces;

    // Auditoria
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Status status = Status.ACTIVE;

    public enum Role {
        USER, ADMIN, DRIVER
    }

    public enum Status {
        ACTIVE, INACTIVE, SUSPENDED, DELETED
    }

}
