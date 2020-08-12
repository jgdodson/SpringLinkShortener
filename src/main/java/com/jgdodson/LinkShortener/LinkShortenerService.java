package com.jgdodson.LinkShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkShortenerService {

    @Autowired
    LinkMappingRepository linkMappingRepository;

    public LinkMapping createLink(String url) {

        // Try to create a new LinkMapping
        try {
            return linkMappingRepository.save(new LinkMapping(url));
        }

        // The url has already been shortened
        catch (Exception e) {

            Optional<LinkMapping> existingLinkMapping = linkMappingRepository.findByUrl(url);

            if (existingLinkMapping.isPresent()) {
                return existingLinkMapping.get();
            } else {
                throw e;
            }
        }
    }

    public Optional<LinkMapping> getLink(Long id) {
        // Get LinkMapping from database
        Optional<LinkMapping> linkMappingOptional = linkMappingRepository.findById(id);

        return linkMappingOptional;
    }
}
