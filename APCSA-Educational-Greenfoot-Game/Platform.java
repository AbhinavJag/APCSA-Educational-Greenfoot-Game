import greenfoot.*;

/**
 * Platform - a plain solid surface the player can stand on, built
 * by tiling the retro block sprite. Used for the ground;
 * AnswerPlatform (a separate class) handles the answer-labeled
 * platforms that gate progress.
 */
public class Platform extends Actor
{
    private static final int TILE_SIZE = 36;

    public Platform(int width, int height)
    {
        GreenfootImage tile = new GreenfootImage("block_tile.png");
        tile.scale(TILE_SIZE, TILE_SIZE);

        GreenfootImage img = new GreenfootImage(width, height);
        for (int x = 0; x < width; x = x + TILE_SIZE) {
            for (int y = 0; y < height; y = y + TILE_SIZE) {
                img.drawImage(tile, x, y);
            }
        }
        setImage(img);
    }
}
