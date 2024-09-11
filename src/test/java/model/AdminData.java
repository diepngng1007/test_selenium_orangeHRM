package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminData {
    private int role;
    private int status;
    private int employee;
    private String username;
    private String password;
    private String confirmPassword;
}