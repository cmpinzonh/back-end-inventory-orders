package com.unir.orders.controller;

import com.unir.orders.model.db.AddRequest;
import com.unir.orders.model.db.Order;
import com.unir.orders.model.request.AddPlayerRequest;
import com.unir.orders.model.request.OrderRequest;
import com.unir.orders.service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AddRequestController {

    private final RequestService service;
    @PostMapping("/add-team")
    public ResponseEntity<AddRequest> createAddRequest(@RequestBody @Valid AddPlayerRequest request) { //Se valida con Jakarta Validation API

        log.info("Creating add player request...");
        AddRequest created = service.createRequest(request);

        if (created != null) {
            return ResponseEntity.ok(created);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/add-team")
    public ResponseEntity<List<AddRequest>> getAddRequests() {

        List<AddRequest> requests = service.getRequests();
        if (requests != null) {
            return ResponseEntity.ok(requests);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @GetMapping("/add-team/{id}")
    public ResponseEntity<AddRequest> getAddRequest(@PathVariable String id) {

        AddRequest addRequest = service.getRequest(id);
        if (addRequest != null) {
            return ResponseEntity.ok(addRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
