package com.jgdodson.LinkShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.util.Optional;

@RestController
public class LinkShortenerController {

    @Autowired
    LinkShortenerService linkShortenerService;

    @GetMapping("/")
    public String hello(@RequestParam(value = "id") Long id, HttpServletResponse httpServletResponse) {

        // Get LinkMapping from database
        Optional<LinkMapping> l = linkShortenerService.getLink(id);

        if (l.isPresent()) {
            httpServletResponse.setHeader("Location", l.get().getUrl());
            httpServletResponse.setStatus(301);

            return "Redirecting...";
        } else {
            httpServletResponse.setStatus(404);

            return "This shortened link is invalid";
        }
    }

    @PostMapping("/")
    public String addLink(@RequestBody String url) {

        LinkMapping savedLinkMapping = linkShortenerService.createLink(url);

        Long linkId = savedLinkMapping.getId();

        String shortUrl = String.format("localhost:8080/?id=%d", linkId);

        return shortUrl;
    }

}
