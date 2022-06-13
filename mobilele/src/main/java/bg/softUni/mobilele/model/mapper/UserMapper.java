package bg.softUni.mobilele.model.mapper;


import org.mapstruct.Mapper;

// With this annotation we define UserMapper int will be mapper,
// componentModel = "spring" means that generated mapper is a Spring bean and
// can be retrieved via @Autowire

@Mapper(componentModel = "spring")
public interface UserMapper {


}
