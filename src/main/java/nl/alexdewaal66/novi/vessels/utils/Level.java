package nl.alexdewaal66.novi.vessels.utils;

public enum Level {
    NONE, ROLE_MEMBER, ROLE_EXPERT, ROLE_ADMIN, ROLE_DEMIURG;

    public boolean greaterThan(Level other) {
        return this.compareTo(other) > 0;
    }
}
