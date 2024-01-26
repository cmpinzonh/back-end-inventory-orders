package com.unir.orders.service;

import com.unir.orders.model.db.AddRequest;
import com.unir.orders.model.request.AddPlayerRequest;

import java.util.List;

public interface RequestService {
    AddRequest createRequest(AddPlayerRequest request);

    AddRequest getRequest(String id);

    List<AddRequest> getRequests();
}
