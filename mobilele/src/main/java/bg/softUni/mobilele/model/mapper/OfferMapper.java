package bg.softUni.mobilele.model.mapper;

import bg.softUni.mobilele.model.dto.AddOfferDto;
import bg.softUni.mobilele.model.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDto addOfferDto);
}
