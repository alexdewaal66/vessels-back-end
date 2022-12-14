package nl.alexdewaal66.novi.vessels.utils;

public class Match<T> {
    T probe;
    String mode;

    public T getProbe() { return probe; }
    public void setProbe(T probe) { this.probe = probe; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    @Override
    public String toString() {
        return "Match{" +
                "probe=" + probe +
                ", mode='" + mode + '\'' +
                '}';
    }
}
