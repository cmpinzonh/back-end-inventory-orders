package com.unir.orders.facade;

import com.unir.orders.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlayersFacade {

    @Value("${getPlayer.url}")
    private String getPlayerUrl;

    private final RestTemplate restTemplate;

    public Player getPlayer(String id) {

        try {
            String url = String.format(getPlayerUrl, id);
            log.info("Getting Player with ID {}. Request to {}", id, url);
            return restTemplate.getForObject(url, Player.class);
        } catch (HttpClientErrorException e) {
            log.error("Client Error: {}, Player with ID {}", e.getStatusCode(), id);
            return null;
        } catch (HttpServerErrorException e) {
            log.error("Server Error: {}, Player with ID {}", e.getStatusCode(), id);
            return null;
        } catch (Exception e) {
            log.error("Error: {}, Player with ID {}", e.getMessage(), id);
            return null;
        }
    }
}
