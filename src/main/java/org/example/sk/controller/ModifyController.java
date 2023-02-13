package org.example.sk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.example.sk.model.request.ModifyRequest;
import org.example.sk.model.responce.ModifyResponse;
import org.example.sk.service.ExampleTableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ModifyController {
    private final ExampleTableService exampleTableService;

    @PostMapping("/modify")
    public ResponseEntity<JsonNode> modify(@RequestBody ModifyRequest request) {
        ModifyResponse modifyResponse = exampleTableService.modify(request.id(), request.add());

        if (modifyResponse.getStatusCode() == -1) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        } else {
            ObjectNode response = JsonNodeFactory.instance.objectNode();
            response.put("current", modifyResponse.getCurrent());
            return ResponseEntity.ok(response);
        }
    }
}
