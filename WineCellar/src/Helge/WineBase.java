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
     * @param type Type of the wine
     * @param name The name of the wine
     * @param vintage The year the wine was is grown.
     * @param characterType The character type according to Systembolaget
     * @param isConsumed True if the wine is consumed (no longer available to drink)
     */
    public WineBase(WineType type, String name, int vintage, CharacterType characterType, boolean isConsumed) {
        this.wineType = type;
        this.name = name;
        this.vintage = vintage;
        this.characterType = characterType;
        this.isConsumed = isConsumed;

    }

    /**
     * Copy constructor
     * @param other The wine to copy
     */
    public WineBase(WineBase other) {
        this.wineType = other.wineType;
        this.name = other.name;
        this.vintage = other.vintage;
        this.characterType = other.characterType;
        this.isConsumed = other.isConsumed;
        this.notes = other.notes;
    }

    /**
     * Return a copy of itself, by calling the copy constructor.
     * @return a copy of itself
     */
    @Override
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
     * @param wineType The type of the wine
     */
    public void setWineType(WineType wineType) {
        this.wineType = wineType;
    }

    /**
     * Return the character type of the wine
     * @return the character type of the wine
     */
    @Override
    public CharacterType getCharacterType() {
        return characterType;
    }

    /**
     * Set the character type of the wine
     * @param characterType the character type of the wine
     */
    @Override
    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    /**
     * Get the name of the wine
     * @return the name of the wine
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the wine
     * @param name the name of the wine
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return the vintage of the wine
     * @return the vintage of the wine
     */
    @Override
    public int getVintage() {
        return vintage;
    }

    /**
     * Set the vintage of the wine
     * @param vintage the vintage of the wine
     */
    @Override
    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    /**
     * Return the date the wine was added to the cellar
     */
    @Override
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Set the date the wine wine was added to the cellar
     */
    @Override
    public void setAdded(Date date) {
        this.dateAdded = date;
    }

    /**
     * Set the consumation statuos of the wine. If true, the wine is consumed
     */
    public void setConsumed(boolean consumed) {
        isConsumed = consumed;
    }

    /**
     * @return True if the wine is consumed
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
     * @return text notes for the wine
     */
    @Override
    public String getNotes() {
        return notes;
    }

    /**
     * Save text notes for the wine
     * @param notes text notes for the wine
     */
    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
