package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.AddOfferDto;
import bg.softUni.mobilele.model.dto.BrandDto;
import bg.softUni.mobilele.model.entity.BrandEntity;
import bg.softUni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;
    private final BrandService brandService;


    public OfferService(OfferRepository offerRepository, BrandService brandService) {
        this.offerRepository = offerRepository;
        this.brandService = brandService;
    }

//    public List<BrandDto> getAllBrands(){
//  todo
//        return this.brandService.getAllBrands().stream().map(b->new BrandDto().se);
//    }

    public void addOffer(AddOfferDto addOfferDto){
        //TODO
    }

}
