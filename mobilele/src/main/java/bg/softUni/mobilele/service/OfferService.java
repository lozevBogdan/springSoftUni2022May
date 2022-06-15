package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.AddOfferDto;
import bg.softUni.mobilele.model.dto.BrandDto;
import bg.softUni.mobilele.model.entity.BrandEntity;
import bg.softUni.mobilele.model.entity.ModelEntity;
import bg.softUni.mobilele.model.entity.OfferEntity;
import bg.softUni.mobilele.model.entity.UserEntity;
import bg.softUni.mobilele.model.mapper.OfferMapper;
import bg.softUni.mobilele.repository.ModelRepository;
import bg.softUni.mobilele.repository.OfferRepository;
import bg.softUni.mobilele.repository.UserRepository;
import bg.softUni.mobilele.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private OfferMapper offerMapper;
    private UserRepository userRepository;
    private CurrentUser currentUser;
    private ModelRepository modelRepository;


    public OfferService(OfferRepository offerRepository, OfferMapper offerMapper,
                        UserRepository userRepository, CurrentUser currentUser,
                        ModelRepository modelRepository) {
        this.offerRepository = offerRepository;

        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelRepository = modelRepository;
    }


    public void addOffer(AddOfferDto addOfferDto){

        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDto);

//TODO -for are we have a logged in user

        UserEntity seller = this.userRepository.
                findByEmail(currentUser.getEmail()).
                orElseThrow();

        ModelEntity modelEntity = this.modelRepository.
                findById(addOfferDto.getModelId()).
                orElseThrow();

        newOffer.setSeller(seller);
        newOffer.setModel(modelEntity);

        this.offerRepository.save(newOffer);



    }



}
