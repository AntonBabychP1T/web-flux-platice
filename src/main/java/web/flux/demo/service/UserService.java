package web.flux.demo.service;

import reactor.core.publisher.Mono;
import web.flux.demo.dto.user.UserRegistrationRequestDto;
import web.flux.demo.dto.user.UserResponseDto;

public interface UserService {
    Mono<UserResponseDto> register(UserRegistrationRequestDto requestDto);
}
