package org.example.sk.service;

import lombok.RequiredArgsConstructor;
import org.example.sk.exception.DataUpdateException;
import org.example.sk.model.entity.ExampleTable;
import org.example.sk.repository.ExampleTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleTableService {

    private final ExampleTableRepository exampleTableRepository;

    @Transactional
    public int modify(long id, int add) throws Exception {
        ExampleTable exampleTable = exampleTableRepository.findById(id).orElseThrow(
                () -> new DataUpdateException("Modify not found by id " + id)
        );

        int result = exampleTable.getObj().getCurrent() + add;
        exampleTable.getObj().setCurrent(result);
        exampleTableRepository.save(exampleTable);

        return result;
    }
}
