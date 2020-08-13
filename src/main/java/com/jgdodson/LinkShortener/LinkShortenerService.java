package com.jgdodson.LinkShortener;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkShortenerService {

    @Autowired
    LinkMappingRepository linkMappingRepository;

    /**
     * Create a new short link
     *
     * Idempotent: If the link has been shortened, the existing short link
     * is returned.
     *
     * @param url The URL to be shortened
     * @return The mapping from short to long link
     */
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

    /**
     * Find the LinkMapping for a shortened link
     *
     * @param id Id of the shortened link
     * @return The mapping from short to long link, if it exists
     */
    public Optional<LinkMapping> getLink(Long id) {
        // Get LinkMapping from database
        Optional<LinkMapping> linkMappingOptional = linkMappingRepository.findById(id);

        return linkMappingOptional;
    }
}
