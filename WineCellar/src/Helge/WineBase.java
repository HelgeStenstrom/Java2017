/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;
import java.util.Date;

public class WineBase implements Wine {

    // Fields
    private CharacterType characterType;
    private Date dateAdded;
    private boolean isConsumed;
    private String name;
    private String notes;
    private int vintage;
    private WineType wineType;


    /**
     * Standard constructor.
     * @param red
     * @param name
     * @param vintage
     * @param druvigt_och_blommigt
     * @param isConsumed
     */
    public WineBase(WineType red, String name, int vintage, CharacterType druvigt_och_blommigt, boolean isConsumed) {
        this.wineType = red;
        this.name = name;
        this.vintage = vintage;
        this.characterType = druvigt_och_blommigt;
        this.isConsumed = isConsumed;

    }

    /**
     * Copy constructor
     * @param other
     */
    public WineBase(WineBase other) {
        this.wineType = other.wineType;
        this. name = other.name;
        this.vintage = other.vintage;
        this.characterType = other.characterType;
        this.isConsumed = other.isConsumed;
    }

    /**
     * Return a copy of itself, by calling the copy constructor.
     * @return
     */
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

    /**
     * Set the type of the wine (red or white)
     * @param wineType
     */
    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    /**
     * Return the character type of the wine
     * @return
     */
    @Override
    public CharacterType getCharacterType() {
        return characterType;
    }

    /**
     * Set the character type of the wine
     * @param characterType
     */
    @Override
    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    /**
     * Get the name of the wine
     * @return
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the wine
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the vintage of the wine
     * @return
     */
    @Override
    public int getVintage() {
        return vintage;
    }

    /**
     * Set the vintage of the wine
     * @param vintage
     */
    @Override
    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    /**
     * Return the date the wine was added to the cellar
     * @return
     */
    @Override
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Set the date the wine wine was added to the cellar
     * @param date
     */
    @Override
    public void setAdded(Date date) {
        this.dateAdded = date;
    }

    /**
     * Set the consumation statuos of the wine. If true, the wine is consumed
     * @param consumed
     */
    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    /**
     * Return True if the wine is consumed
     * @return
     */
    @Override
    public Boolean isConsumed() {
        return isConsumed;
    }

    /**
     * Mark the wine as consumed.
     */
    @Override
    public void consume() {
        isConsumed = true;
    }

    /**
     * Mark the wine as not consumed
     */
    @Override
    public void unConsume() {
        isConsumed = false;
    }

    /**
     * Return text notes for the wine
     * @return
     */
    @Override
    public String getNotes() {
        return notes;
    }

    /**
     * Save text notes for the wine
     * @param notes
     */
    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * This list of values is useful for populating a list of wines.
     * @return
     */
    public ArrayList<String> getRowStrings() {
        ArrayList<String> result = new ArrayList<>();
        result.add(name);
        result.add(wineType.toString());
        result.add(Integer.toString(vintage));
        result.add(characterType.toString());
        return result;
    }

}
