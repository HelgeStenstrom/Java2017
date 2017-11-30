package Helge;

public class White extends WineBase {

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
