package org.structures.advanced.cuckoo_hashtable;

public interface IHashTable<T> {

    int hash(T x, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();

}
