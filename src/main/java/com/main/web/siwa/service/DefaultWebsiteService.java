package com.main.web.siwa.service;

import com.main.web.siwa.entity.Website;
import com.main.web.siwa.repository.WebsiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultWebsiteService implements WebsiteService {

    private WebsiteRepository websiteRepository;

    public DefaultWebsiteService(WebsiteRepository websiteRepository){
        this.websiteRepository = websiteRepository;
    }

    @Override
    public List<Website> getList() {
        return websiteRepository.findAll();
    }
}
