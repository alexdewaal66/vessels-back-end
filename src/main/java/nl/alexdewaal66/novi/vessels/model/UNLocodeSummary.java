package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.infrastructure.SummaryProjection;

public interface UNLocodeSummary extends SummaryProjection<UNLocode> {

    String getAlpha2Code();
    String getLocationCode();
    String getNameWoDiacritics();
}
