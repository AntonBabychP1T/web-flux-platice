package web.flux.demo.secutiry;

import web.flux.demo.dto.login.LoginRequestDto;
import web.flux.demo.dto.login.LoginResponseDto;

public interface AuthenticationService {
    LoginResponseDto authentication(LoginRequestDto requestDto);
}
