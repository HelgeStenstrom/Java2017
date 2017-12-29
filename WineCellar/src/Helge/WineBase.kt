/*
 * Copyright (c) 2017. Helge Stenström
 */

package Helge

import javafx.beans.value.ObservableValue

import java.util.ArrayList
import java.util.Date

open class WineBase : Wine {

    // Fields
    private var characterType: CharacterType? = null
    private var dateAdded: Date? = null
    private var isConsumed: Boolean = false
    private var name: String? = null
    private var notes: String? = null
    private var vintage: Int = 0
    private var wineType: WineType? = null

    /**
     * This list of values is useful for populating a list of wines.
     * @return
     */
    val rowStrings: ArrayList<String>
        get() {
            val result = ArrayList<String>()
            result.add(name.toString()) // TODO: Förstå varför toString() är nödvändigt. name är ju en String.
            result.add(wineType!!.toString())
            result.add(Integer.toString(vintage))
            result.add(characterType!!.toString())
            return result
        }


    /**
     * Standard constructor.
     * @param type The type of the wine
     * @param name The name of the wine
     * @param vintage The year the wine was harvested.
     * @param characterType The character type according to Systembolaget
     * @param isConsumed True if the wine is consumed.
     */
    constructor(type: WineType, name: String, vintage: Int, characterType: CharacterType, isConsumed: Boolean) {
        this.wineType = type
        this.name = name
        this.vintage = vintage
        this.characterType = characterType
        this.isConsumed = isConsumed

    }

    /**
     * Copy constructor
     * @param other the wine to copy
     */
    constructor(other: WineBase) {
        this.wineType = other.wineType
        this.name = other.name
        this.vintage = other.vintage
        this.characterType = other.characterType
        this.isConsumed = other.isConsumed
    }

    /**
     * Return a copy of itself, by calling the copy constructor.
     * @return A copy of itself
     */
    override fun clone(): WineBase {
        return WineBase(this)
    }

    /**
     * Differentiate between red or white wine (and possibly other variants)
     *
     * @return wine type.
     */
    override fun getWineType(): WineType? {
        return this.wineType
    }

    /**
     * Set the type of the wine (red or white)
     * @param wineType
     */
    override fun setWineType(wineType: WineType) {
        this.wineType = wineType
    }

    /**
     * Return the character type of the wine
     * @return
     */
    override fun getCharacterType(): CharacterType? {
        return characterType
    }

    /**
     * Set the character type of the wine
     * @param characterType
     */
    override fun setCharacterType(characterType: CharacterType) {
        this.characterType = characterType
    }

    /**
     * Get the name of the wine
     * @return
     */
    override fun getName(): String? {
        return this.name
    }

    /**
     * Set the name of the wine
     * @param name
     */
    override fun setName(name: String) {
        this.name = name
    }

    /**
     * Return the vintage of the wine
     * @return
     */
    override fun getVintage(): Int {
        return vintage
    }

    /**
     * Set the vintage of the wine
     * @param vintage
     */
    override fun setVintage(vintage: Int) {
        this.vintage = vintage
    }

    /**
     * Return the date the wine was added to the cellar
     * @return
     */
    override fun getDateAdded(): Date? {
        return dateAdded
    }

    /**
     * Set the date the wine wine was added to the cellar
     * @param date
     */
    override fun setAdded(date: Date) {
        this.dateAdded = date
    }

    /**
     * Set the consumation statuos of the wine. If true, the wine is consumed
     * @param consumed
     */
    fun setConsumed(consumed: Boolean) {
        isConsumed = consumed
    }

    /**
     * Return True if the wine is consumed
     * @return
     */
    override fun isConsumed(): Boolean? {
        return isConsumed
    }

    /**
     * Mark the wine as consumed.
     */
    override fun consume() {
        isConsumed = true
    }

    /**
     * Mark the wine as not consumed
     */
    override fun unConsume() {
        isConsumed = false
    }

    /**
     * Return text notes for the wine
     * @return
     */
    override fun getNotes(): String? {
        return notes
    }

    /**
     * Save text notes for the wine
     * @param notes
     */
    override fun setNotes(notes: String) {
        this.notes = notes
    }

}
