package com.unir.orders.service;

import com.unir.orders.data.RequestJpaRepository;
import com.unir.orders.facade.PlayersFacade;
import com.unir.orders.model.Player;
import com.unir.orders.model.db.AddRequest;
import com.unir.orders.model.request.AddPlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService{

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private PlayersFacade playersFacade;

    @Autowired //Inyeccion por campo (field injection). Es la menos recomendada.
    private RequestJpaRepository repository;
    @Override
    public AddRequest createRequest(AddPlayerRequest request) {
        List<Player> players = request.getPlayers().stream().map(playersFacade::getPlayer).filter(Objects::nonNull).toList();

        if(players.size() != request.getPlayers().size()) {
            return null;
        } else {
            AddRequest addRequest = AddRequest.builder().players(players.stream().map(Player::getId).collect(Collectors.toList())).build();
            repository.save(addRequest);
            return addRequest;
        }
    }

    @Override
    public AddRequest getRequest(String id) {
        return repository.findById(Long.valueOf(id)).orElse(null);
    }

    @Override
    public List<AddRequest> getRequests() {
        List<AddRequest> addRequests = repository.findAll();
        return addRequests.isEmpty() ? null : addRequests;
    }
}
