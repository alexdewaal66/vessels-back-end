package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface VesselSummary extends SummaryProjection<Vessel> {

    String getName();
    ImgThumbnail getImage();

    interface ImgThumbnail {
        Long getThumbnailId();
    }
}
