package com.jgdodson.LinkShortener;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LinkMappingRepository extends CrudRepository<LinkMapping, Long> {

    Optional<LinkMapping> findByUrl(String link);
}
