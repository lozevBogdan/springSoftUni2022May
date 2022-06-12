package bg.softuni.pathfinder.dto;

import javax.validation.constraints.*;

public class UserRegistrationDto {

    @NotNull
    @Size(min = 5,max = 20)
    private String username;

    @NotNull
    @Size(min = 5,max = 20)
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(0)
    @Max(90)
    private int age;

    @NotNull
    @Size(min = 5,max = 20)
    private String password;

    @NotNull
    @Size(min = 5,max = 20)
    private String confirmPassword;


    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public UserRegistrationDto setFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getAge() {
        return age;
    }

    public UserRegistrationDto setAge(int age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
