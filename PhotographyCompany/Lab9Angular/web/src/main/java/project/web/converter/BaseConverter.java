package project.web.converter;


import project.core.model.BaseEntity;
import project.web.dto.BaseDto;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseConverter<Model extends BaseEntity<Long>, Dto extends BaseDto>
        implements Converter<Model, Dto> {

    public Set<Long> convertModelsToIDs(Set<Model> models){
        return models.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }


    public Set<Long> convertDtosToIDs(Set<Dto> dtos){
        return dtos.stream()
                .map(BaseDto::getId)
                .collect(Collectors.toSet());
    }

    public Set<Dto> convertModelsToDtos(Collection<Model> models){
        return models.stream()
                .map(this::convertModelToDto)
                .collect(Collectors.toSet());
    }

}
