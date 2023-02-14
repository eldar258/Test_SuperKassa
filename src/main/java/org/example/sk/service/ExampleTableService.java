package org.example.sk.service;

import lombok.RequiredArgsConstructor;
import org.example.sk.model.responce.ModifyResponse;
import org.example.sk.repository.ExampleTableRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleTableService {

    private final ExampleTableRepository exampleTableRepository;

    public ModifyResponse modify(long id, int add) {
        ModifyResponse.ModifyResponseBuilder resultBuilder = ModifyResponse.builder();

        int updateCount = 0;
        try {
            updateCount = exampleTableRepository.updateCurrent(id, add);
        } catch (RuntimeException sqlException) {
            sqlException.printStackTrace();
        }

        if (updateCount != 0) {
            resultBuilder.statusCode(0);
            exampleTableRepository.findById(id).ifPresent(
                    current -> resultBuilder.current(current.getObj().get("current").asInt())
            );
        } else {
            resultBuilder.statusCode(-1);
        }

        return resultBuilder.build();
    }
}
