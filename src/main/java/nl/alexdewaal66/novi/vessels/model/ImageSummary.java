package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface ImageSummary extends SummaryProjection<Image> {

    Long getId();

    Long getThumbnailId();

}
