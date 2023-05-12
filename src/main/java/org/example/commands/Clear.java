package org.example.commands;

import org.example.file.Collection;

/**
 * @author Mikhail Kadilov
 * Clear the collection
 */
public class Clear extends Command{
    private Collection collection;

    public Clear(Collection collection) {
        this.collection = collection;
    }

    /**
     * The function clears the collection
     */
    @Override
    public void execute(String[] args) {
        collection.clear();
    }
}
