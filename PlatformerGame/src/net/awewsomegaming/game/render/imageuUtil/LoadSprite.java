package net.awewsomegaming.game.render.imageuUtil;

import java.awt.image.BufferedImage;

public class LoadSprite {
	public BufferedImage loadSpriteSheetSquare(int x, int y, BufferedImage spriteSheet) {
		BufferedImage seg = spriteSheet.getSubimage((x*32)-32, (y*32)-32, 32, 32);
		return seg;
	}
}
