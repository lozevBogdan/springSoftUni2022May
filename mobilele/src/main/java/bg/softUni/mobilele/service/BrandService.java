package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.entity.BrandEntity;
import bg.softUni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<BrandEntity> getAllBrands(){
        return this.brandRepository.findAll();
    }
}
