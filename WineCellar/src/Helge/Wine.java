package Helge;

import javafx.beans.value.ObservableValue;

import java.util.Date;

/**
 * The Wine interface is mainly used to formalize what methods that WineBase must have.
 * Having variables of the type Wine appears to mostly be problematic, it's better to use WineBase.
 */
public interface Wine {
    /**
     * Differentiate between red or white wine (and possibly other variants)
     * @return wine type.
     */

    public Wine clone();

    public WineType getWineType();
    public void setWineType(WineType wineType);

    public CharacterType getCharacterType();
    public void setCharacterType(CharacterType characterType);

    public String getName();
    public void setName(String name);

    public int getVintage();
    public void setVintage(int vintage);

    public Date getDateAdded();
    public void setAdded(Date date);

    public Boolean isConsumed();
    public void consume();
    public void unConsume();

    public String getNotes();
    public void setNotes(String notes);
}
