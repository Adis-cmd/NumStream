package com.numberservice.numstream.service.impl;

import com.numberservice.numstream.entity.Number;
import com.numberservice.numstream.repo.NumberRepository;
import com.numberservice.numstream.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {
    private final NumberRepository repository;

    @Override
    public List<Integer> saveNumber(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("Number cannot be null");
        }
        repository.save(Number.builder().value(value).build());

        return repository.findAllByOrderByValueAsc()
                .stream()
                .map(Number::getValue)
                .collect(Collectors.toList());
    }
}
