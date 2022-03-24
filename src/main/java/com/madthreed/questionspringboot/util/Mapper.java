package com.madthreed.questionspringboot.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper mapper = new ModelMapper();


    public <T, S> T mapper(S source, Class<T> tClass) {

        return mapper.map(source, tClass);
    }
}
