package Helge;

import Helge.Wine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class WineBase implements Wine {
    /**
     * Differentiate between red or white wine (and possibly other variants)
     *
     * @return wine type.
     */
    @Override
    public WineType getWineType() {
        // throw new NotImplementedException();
        return WineType.Red;
    }

    @Override
    public CharacterType getCharacterType() {
        throw new NotImplementedException();
    }

    @Override
    public void setCharacterType(CharacterType characterType) {
        throw new NotImplementedException();
    }

    @Override
    public String getName() {
        throw new NotImplementedException();
    }

    @Override
    public void setName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public int getVintage() {
        throw new NotImplementedException();
    }

    @Override
    public void setVintage(int vintage) {
        throw new NotImplementedException();
    }

    @Override
    public Date getDateAdded() {
        throw new NotImplementedException();
    }

    @Override
    public void setAdded(Date date) {
        throw new NotImplementedException();
    }

    @Override
    public Boolean isConsumed() {
        throw new NotImplementedException();
    }

    @Override
    public void consume() {
        throw new NotImplementedException();
    }

    @Override
    public void unConsume() {
        throw new NotImplementedException();
    }
}
