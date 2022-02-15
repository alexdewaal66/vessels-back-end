package nl.alexdewaal66.novi.vessels.repository;

import nl.alexdewaal66.novi.vessels.generics.GenericRepository;
import nl.alexdewaal66.novi.vessels.model.Image;
import nl.alexdewaal66.novi.vessels.model.ImageSummary;

import java.util.Collection;

public interface ImageRepository extends GenericRepository<Image> {

    Collection<ImageSummary> findAllSummariesBy();

    Collection<ImageSummary> findSummariesByIdIn(Collection<Long> ids);

    ImageSummary findSummaryById(Long id);

}
