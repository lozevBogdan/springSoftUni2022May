package bg.softUni.mobilele.model.dto;

import java.util.List;

public class BrandDto {

    private List<ModelDto> models;

    public List<ModelDto> getModels() {
        return models;
    }

    public BrandDto setModels(List<ModelDto> models) {
        this.models = models;
        return this;
    }

    public BrandDto addModel(ModelDto model) {
        this.models.add(model);
        return this;
    }
}
