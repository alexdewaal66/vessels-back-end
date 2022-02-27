package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface VesselSummary extends SummaryProjection<Vessel> {

    String getName();
    ImgThumbnail getImage();

    interface ImgThumbnail {
        Long getThumbnailId();
    }
}
