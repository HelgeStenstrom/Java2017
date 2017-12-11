package Helge;

import java.util.Date;

public interface Wine {
    /**
     * Differentiate between red or white wine (and possibly other variants)
     * @return wine type.
     */

    public Wine clone();

    public WineType getWineType();

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
}
