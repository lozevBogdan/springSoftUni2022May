package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.AddOfferDto;
import bg.softUni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void addOffer(AddOfferDto addOfferDto){
        //TODO
    }

}
