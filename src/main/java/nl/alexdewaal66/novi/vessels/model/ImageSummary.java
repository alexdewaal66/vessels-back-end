package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface ImageSummary extends SummaryProjection<Image> {

    Long getId();
    DBFile getThumbnail();
}
