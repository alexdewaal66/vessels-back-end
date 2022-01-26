package nl.alexdewaal66.novi.vessels.model;

import nl.alexdewaal66.novi.vessels.generics.SummaryProjection;

public interface UNLocodeSummary extends SummaryProjection<UNLocode> {

    Long getId();
    String getAlpha2Code();
    String getLocationCode();
    String getNameWoDiacritics();
}
