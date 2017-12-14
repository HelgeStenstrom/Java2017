/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.Date;

public class WineBase implements Wine {
    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    private CharacterType characterType;
    private Date dateAdded;
    private boolean isConsumed;
    private String name;
    private String notes;
    private int vintage;
    private WineType wineType;

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

    public ArrayList<String> getRowStrings() {
        ArrayList<String> result = new ArrayList<>();
        result.add(name);
        result.add(wineType.toString());
        result.add(Integer.toString(vintage));
        result.add(characterType.toString());
        return result;
    }

    // TODO: gör klart nästa rad, eller ta bort.
    // public final ObjectProperty<>

}
