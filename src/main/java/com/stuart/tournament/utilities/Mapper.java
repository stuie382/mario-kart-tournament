package com.stuart.tournament.utilities;

import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Mapper {

    private ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Convert the {@code sourceCollection} into a {@link Set} of the {@code targetClass}.
     * <p>
     * Use this to convert from Entity into DTO, or from DTO to Entity
     *
     * @param sourceCollection -  The collection of things to convert.
     * @param targetClass      - The target class to convert to
     * @param <S>              - The input type
     * @param <T>              - The output type
     * @return The converted set.
     */
    public <S, T> Set<T> convertCollection(Collection<S> sourceCollection, Class<T> targetClass) {
        return sourceCollection.stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toSet());
    }

    /**
     * Convert a single  {@code source} into an instance of the {@code targetClass}.
     *
     * @param source - The object to convert
     * @param targetClass - The class to convert it to
     * @param <S> - The input type
     * @param <T> - The output type
     *
     * @return - The converted single instance
     */
    public <S, T> T convertSingle(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

}
