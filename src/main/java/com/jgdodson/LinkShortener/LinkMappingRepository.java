package com.jgdodson.LinkShortener;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for working with LinkMapping entities. Implementation class is
 * generated at runtime by JPA.
 */
public interface LinkMappingRepository extends CrudRepository<LinkMapping, Long> {

    Optional<LinkMapping> findByUrl(String link);
}
