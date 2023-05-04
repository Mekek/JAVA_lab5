package org.example.commands;

import org.example.Exception.WrongTypeException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;

/**
 * The `CountByPrice` class is a command that counts all elements in collection with the same price, as the argument
 */
public class CountByPrice extends Command{
    private Collection collection;
    public CountByPrice(Collection collection) {
        this.collection=collection;
    }

    /**
     * * Counts all the organizations in the collection with the same price
     * @param args the arguments passed to the command.
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            if (!HelperUtil.checkFloat(args[0])) throw new WrongTypeException();
            float price = Float.parseFloat(args[0]);
            collection.CountByPrice(price);
        } else {
            System.out.println("Некорректное количество аргументов");
        }
    }
}
