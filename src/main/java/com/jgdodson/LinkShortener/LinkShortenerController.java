package com.jgdodson.LinkShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class LinkShortenerController {

    @Autowired
    LinkMappingRepository linkMappingRepository;

    @GetMapping("/")
    public String hello(@RequestParam(value = "id") Long id, HttpServletResponse httpServletResponse) {

        // Get LinkMapping from database
        Optional<LinkMapping> l = linkMappingRepository.findById(id);

        if (l.isPresent()) {
            httpServletResponse.setHeader("Location", l.get().getLink());
            httpServletResponse.setStatus(301);

            return "Redirecting...";
        } else {
            httpServletResponse.setStatus(404);

            return "This shortened link is invalid";
        }
    }

    @PostMapping("/")
    public String addLink(@RequestBody String link) {

        // TODO: Handle duplicate links

        LinkMapping linkMapping = new LinkMapping(link);

        LinkMapping savedLinkMapping = linkMappingRepository.save(linkMapping);

        return savedLinkMapping.getId().toString();
    }

}
