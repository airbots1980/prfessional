package edu.unl.hcc.code.utils;

/**
 * Abstract class for all unility objects
 */

public abstract class Util<T> {
    /**
     * Method to print the given type of data structure.
     * @param t
     */
    public void print(T t) {}

    /**
     * Method to create given type of data structure.
     * @return
     */
    public T create() { return null;}
}