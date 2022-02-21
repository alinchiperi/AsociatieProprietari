package ro.usv.dao;

import java.io.Serializable;

/**
 * @author Alin CHIPERI
 * @grupa 3131a
 * @nr 1
 */

public abstract class Entitate<K> implements Serializable {

    public abstract K getId();

    @Override
    public boolean equals(Object oid) {
        if (this == oid) return true;
        if (oid == null || !(oid instanceof Entitate))
            return false;
        K cheie = ((Entitate<K>) oid).getId();
        return cheie != null ? cheie.equals(this.getId()) : getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
