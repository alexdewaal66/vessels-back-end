package nl.alexdewaal66.novi.vessels.payload;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericEntity;
import nl.alexdewaal66.novi.vessels.infrastructure.deletion.Deletion;

import java.util.Collection;

public class Mutations<T extends GenericEntity<T>> {
    Collection<T> fresh;
    Collection<Deletion> deletions;

    public Mutations(Collection<T> fresh, Collection<Deletion> deletions) {
        this.fresh = fresh;
        this.deletions = deletions;
    }

    public Collection<T> getFresh() {return fresh;}
    public void setFresh(Collection<T> fresh) {this.fresh = fresh;}
    
    public Collection<Deletion> getDeletions() {return deletions;}
    public void setDeletions(Collection<Deletion> deletions) {
        this.deletions = deletions;}
}
