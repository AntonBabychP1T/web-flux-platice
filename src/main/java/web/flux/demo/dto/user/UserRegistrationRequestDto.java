package web.flux.demo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequestDto(@Email String email, @Size(min = 6) String password) {
}
