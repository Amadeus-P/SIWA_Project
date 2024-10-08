package com.main.web.siwa.service;

import com.main.web.siwa.entity.Website;
import com.main.web.siwa.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultHomeService implements HomeService {

    private HomeRepository homeRepository;

    public DefaultHomeService(HomeRepository homeRepository){
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Website> getList() {
        return List.of();
    }
}
