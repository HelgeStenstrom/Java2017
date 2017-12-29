package Helge

import javafx.beans.value.ObservableValue

import java.util.Date

/**
 * The Wine interface is mainly used to formalize what methods that WineBase must have.
 * Having variables of the type Wine appears to mostly be problematic, it's better to use WineBase.
 */
interface Wine {

    var wineType: WineType

    var characterType: CharacterType

    var name: String

    var vintage: Int

    val dateAdded: Date

    val isConsumed: Boolean?

    var notes: String
    /**
     * Differentiate between red or white wine (and possibly other variants)
     * @return wine type.
     */

    fun clone(): Wine

    fun setAdded(date: Date)
    fun consume()
    fun unConsume()
}
