package Helge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class WineBase implements Wine {
    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    private WineType wineType;
    private String name;
    private int vintage;
    private CharacterType characterType;
    private boolean isConsumed;
    private String notes;
    private Date dateAdded;

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
        return this.wineType;
    }

    @Override
    public CharacterType getCharacterType() {
        return characterType;
    }

    @Override
    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getVintage() {
        return vintage;
    }

    @Override
    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    @Override
    public Date getDateAdded() {
        return dateAdded;
    }

    @Override
    public void setAdded(Date date) {
        this.dateAdded = date;
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

    @Override
    public String getNotes() {
        return notes;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
