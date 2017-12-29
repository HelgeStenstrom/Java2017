package Helge

class White
/**
 * Subclass of WineBase, behaves like the same, but with the wineType White.
 * A future improvement would be to have different character types available for White and Red.
 * @param name
 * @param vintage
 * @param characterType
 * @param isConsumed
 */
(name: String, vintage: Int, characterType: CharacterType, isConsumed: Boolean) : WineBase(WineType.White, name, vintage, characterType, isConsumed) {

    /**
     * Differentiate between red or white wine (and possibly other variants)
     *
     * @return wine type.
     */
    override fun getWineType(): WineType {
        // throw new NotImplementedException();
        return WineType.White
    }

    companion object {

        /**
         * Generate an example wine to be used for development, and to initially fill in the form.
         * @return
         */
        fun exampleWhite(): White {
            return White("Exempelvin", 1999, CharacterType.Druvigt_och_blommigt, false)
        }
    }
}
