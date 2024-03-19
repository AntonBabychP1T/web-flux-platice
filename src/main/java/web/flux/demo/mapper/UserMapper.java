package web.flux.demo.mapper;

import org.mapstruct.Mapper;
import web.flux.demo.config.MapperConfig;
import web.flux.demo.dto.user.UserRegistrationRequestDto;
import web.flux.demo.dto.user.UserResponseDto;
import web.flux.demo.user.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRegistrationRequestDto requestDto);

    UserResponseDto toDto(User user);
}
