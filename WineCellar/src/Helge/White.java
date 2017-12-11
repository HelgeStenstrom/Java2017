package Helge;

public class White extends WineBase {

    public White(String name, int vintage, CharacterType druvigt_och_blommigt, boolean isConsumed) {
        super(WineType.White, name, vintage, druvigt_och_blommigt, isConsumed);
    }

    public static White exampleWhite() {
        return new White("name", 1999, CharacterType.Druvigt_och_blommigt, false);
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
