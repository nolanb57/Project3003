/**

 * Interface for the multimedia controls.

 * used to execute the multimedia controls.

 * @author Nolan Birmingham

 */
public interface MultimediaControl{

    /**

     * "Plays" the player.

     */
    public void play();

    /**

     * "Stops" the player.

     */
    public void stop();

    /**

     * "Plays" the next track in the player.

     */
    public void next();

    /**

     * "Plays" the previous track in the player.

     */
    public void previous();
}
