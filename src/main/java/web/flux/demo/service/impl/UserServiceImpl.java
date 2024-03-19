package web.flux.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import web.flux.demo.dto.user.UserRegistrationRequestDto;
import web.flux.demo.dto.user.UserResponseDto;
import web.flux.demo.mapper.UserMapper;
import web.flux.demo.repository.UserRepository;
import web.flux.demo.service.UserService;
import web.flux.demo.user.User;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<UserResponseDto> register(UserRegistrationRequestDto requestDto) {
        return userRepository.findByEmail(requestDto.email())
                .flatMap(existingUser -> Mono.error(new RuntimeException("This email already registered")))
                .switchIfEmpty(Mono.defer(() -> {
                    User user = userMapper.toModel(requestDto);
                    user.setPassword(passwordEncoder.encode(requestDto.password()));
                    return userRepository.save(user);
                }))
                .cast(User.class)
                .map(userMapper::toDto);
    }
}
