package com.jgdodson.LinkShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkShortenerService {
    @Autowired
    LinkMappingRepository linkMappingRepository;

    // TODO: Handle duplicate links
    public LinkMapping createLink(String url) {

        LinkMapping savedLinkMapping = linkMappingRepository.save(new LinkMapping(url));

        return savedLinkMapping;
    }

    public Optional<LinkMapping> getLink(Long id) {
        // Get LinkMapping from database
        Optional<LinkMapping> linkMappingOptional = linkMappingRepository.findById(id);

        return linkMappingOptional;
    }
}
