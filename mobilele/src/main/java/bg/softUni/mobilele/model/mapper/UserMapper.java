package bg.softUni.mobilele.model.mapper;


import bg.softUni.mobilele.model.dto.UserRegisterDto;
import bg.softUni.mobilele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// With this annotation we define UserMapper int will be mapper,
// componentModel = "spring" means that generated mapper is a Spring bean and
// can be retrieved via @Autowire

@Mapper(componentModel = "spring")
public interface UserMapper {

    // with  @Mapping(target = "active", constant = "true"), we set for property "active"
    // value "true"

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegisterDto userRegisterDto);

}
