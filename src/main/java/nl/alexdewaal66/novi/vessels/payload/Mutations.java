package nl.alexdewaal66.novi.vessels.payload;

import nl.alexdewaal66.novi.vessels.infrastructure.GenericEntity;
import nl.alexdewaal66.novi.vessels.infrastructure.deletion.Deletion;

import java.util.Collection;

public class Mutations<T extends GenericEntity<T>> {
    Collection<T> fresh;
    Collection<Deletion> deleted;

    public Mutations(Collection<T> fresh, Collection<Deletion> deleted) {
        this.fresh = fresh;
        this.deleted = deleted;
    }

    public Collection<T> getFresh() {return fresh;}
    public void setFresh(Collection<T> fresh) {this.fresh = fresh;}
    
    public Collection<Deletion> getDeleted() {return deleted;}
    public void setDeleted(Collection<Deletion> deleted) {
        this.deleted = deleted;}
}
