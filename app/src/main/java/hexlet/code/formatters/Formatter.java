package hexlet.code.formatters;

import hexlet.code.formatters.plain.Plain;
import hexlet.code.formatters.stylish.Stylish;

public class Formatter {

    public Format getFormat(String nameOfFormat) {
        if (nameOfFormat.equals("stylish")) {
            return new Stylish();
        }
        return new Plain();
    }
}
