package com.example.battleShips.service;

import com.example.battleShips.repositories.ShipRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipService {

    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }
}
