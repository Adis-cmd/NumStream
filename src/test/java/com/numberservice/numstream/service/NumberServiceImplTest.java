package com.numberservice.numstream.service;

import com.numberservice.numstream.entity.Number;
import com.numberservice.numstream.repo.NumberRepository;
import com.numberservice.numstream.service.impl.NumberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumberServiceImplTest {

    private NumberRepository repository;
    private NumberServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(NumberRepository.class);
        service = new NumberServiceImpl(repository);
    }

    @Test
    void saveNumber_shouldThrowException_whenValueIsNull() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> service.saveNumber(null));
        assertEquals("Number cannot be null", ex.getMessage());
    }

    @Test
    void saveNumber_shouldSaveNumberAndReturnSortedList() {
        when(repository.findAllByOrderByValueAsc()).thenReturn(List.of(
                Number.builder().value(3).build(),
                Number.builder().value(5).build(),
                Number.builder().value(7).build()
        ));

        List<Integer> result = service.saveNumber(5);

        verify(repository, times(1)).save(any(Number.class));
        assertEquals(List.of(3, 5, 7), result);
    }
}
