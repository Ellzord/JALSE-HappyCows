package happycows.attributes;

import jalse.attributes.Attribute;

public class Size implements Attribute {

    private final int width;
    private final int height;

    public Size(final int width, final int height) {

	this.width = width;
	this.height = height;
    }

    public int getHeight() {

	return height;
    }

    public int getWidth() {

	return width;
    }
}
