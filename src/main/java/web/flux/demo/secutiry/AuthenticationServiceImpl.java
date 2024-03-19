package web.flux.demo.secutiry;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import web.flux.demo.dto.login.LoginRequestDto;
import web.flux.demo.dto.login.LoginResponseDto;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final ReactiveAuthenticationManager manager;
    private final JwtUtil jwtUtil;

    public Mono<LoginResponseDto> authenticate(LoginRequestDto requestDto) {
        return manager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.email(), requestDto.password()))
                .map(auth -> {
                    String token = jwtUtil.generateToken(auth.getName());
                    return new LoginResponseDto(token);
                });
    }
}
