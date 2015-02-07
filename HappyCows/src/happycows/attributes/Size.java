package happycows.attributes;

import jalse.attributes.Attribute;

public class Size implements Attribute {

    private final int width;
    private final int heigt;

    public Size(final int width, final int height) {

	this.width = width;
	heigt = height;
    }

    public int getHeight() {

	return heigt;
    }

    public int getWidth() {

	return width;
    }
}
