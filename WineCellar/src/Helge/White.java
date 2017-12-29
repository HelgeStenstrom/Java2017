package Helge;

public class White extends WineBase {

    /**
     * Subclass of WineBase, behaves like the same, but with the wineType White.
     * A future improvement would be to have different character types available for White and Red.
     * @param name
     * @param vintage
     * @param characterType
     * @param isConsumed
     */
    public White(String name, int vintage, CharacterType characterType, boolean isConsumed) {
        super(WineType.White, name, vintage, characterType, isConsumed);
    }

    /**
     * Generate an example wine to be used for development, and to initially fill in the form.
     * @return
     */
    public static White exampleWhite() {
        return new White("Exempelvin", 1999, CharacterType.Druvigt_och_blommigt, false);
    }

    /**
     * Differentiate between red or white wine (and possibly other variants)
     *
     * @return wine type.
     */
    @Override
    public WineType getWineType() {
        // throw new NotImplementedException();
        return WineType.White;
    }
}
