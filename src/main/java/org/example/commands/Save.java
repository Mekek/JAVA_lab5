package org.example.commands;

import org.example.file.Collection;

/**
 * @author Mikhail Kadilov
 * Write the collection to the file
 */
public class Save extends Command{
    private Collection collection;

    public Save(Collection collection) {
        this.collection = collection;
    }
    /**
     * Write the collection to the file
     */
    @Override
    public void execute(String[] args){
        collection.save();
    }
}
