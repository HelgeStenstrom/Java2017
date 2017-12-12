package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class WineBase implements Wine {
    private final WineType wineType;
    private final String name;
    private final int vintage;
    private final CharacterType characterType;
    private boolean isConsumed;

    public WineBase(WineType red, String name, int vintage, CharacterType druvigt_och_blommigt, boolean isConsumed) {
        this.wineType = red;
        this.name = name;
        this.vintage = vintage;
        this.characterType = druvigt_och_blommigt;
        this.isConsumed = isConsumed;

    }

    public WineBase(WineBase other) {
        this.wineType = other.wineType;
        this. name = other.name;
        this.vintage = other.vintage;
        this.characterType = other.characterType;
        this.isConsumed = other.isConsumed;
    }

    public WineBase clone() {
        return new WineBase(this);
    }

    /**
     * Differentiate between red or white wine (and possibly other variants)
     *
     * @return wine type.
     */
    @Override
    public WineType getWineType() {
        // throw new NotImplementedException();
        return this.wineType;
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
        return this.name;
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
        return isConsumed;
    }

    @Override
    public void consume() {
        isConsumed = true;
    }

    @Override
    public void unConsume() {
        isConsumed = false;
    }
}
