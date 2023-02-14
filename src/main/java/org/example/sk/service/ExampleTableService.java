package org.example.sk.service;

import java.sql.SQLException;
import java.util.Optional;
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

    public int modify(long id, int add) throws Exception {
        int updateCount;
        try {
            updateCount = exampleTableRepository.updateCurrent(id, add);
        } catch (RuntimeException sqlException) {
            sqlException.printStackTrace();
            throw new SQLException(sqlException.getMessage());
        }

        if (updateCount == 0) throw new DataUpdateException("Update count == 0");

        int result = 0;
        Optional<ExampleTable> exampleTableOptional = exampleTableRepository.findById(id);
        if (exampleTableOptional.isPresent()) {
            result = exampleTableOptional.get().getObj().getCurrent();
        }

        return result;
    }
}
