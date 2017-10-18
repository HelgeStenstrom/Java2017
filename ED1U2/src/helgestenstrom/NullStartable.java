/*
 * Copyright (c) 2017. Helge Stenström
 */

package helgestenstrom;

public class NullStartable implements Startable {
    // Denna klass kommer i praktiken inte att anropas, åtminstone inte dess start()-funktion.

    // A null object is useful as default value.

    @Override
    public void start() {
        // Do nothing.
    }
}
