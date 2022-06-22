package bg.softUni.mobilele.service;

import bg.softUni.mobilele.model.dto.BrandDto;
import bg.softUni.mobilele.model.dto.ModelDto;
import bg.softUni.mobilele.model.entity.BrandEntity;
import bg.softUni.mobilele.model.entity.ModelEntity;
import bg.softUni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandDto> getAllBrands() {
        return this.brandRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    private BrandDto map(BrandEntity brand) {

        List<ModelDto> modelsDto = brand.
                getModels().
                stream().
                map(this::mapModel).collect(Collectors.toList());

        BrandDto result = new BrandDto();

        result.
                setName(brand.getName()).
                setModels(modelsDto);

        return result;

    }

    private ModelDto mapModel(ModelEntity modelEntity) {

        return new ModelDto().
                setName(modelEntity.getName()).
                setId(modelEntity.getId());


    }

}
