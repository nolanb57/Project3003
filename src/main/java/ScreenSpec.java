/**

 * Interface of the screen specifications.

 * used with functions to define elements of the screen.

 * @author Nolan Birmingham

 */
public interface ScreenSpec{
    /**

     * Gets the resolution for the screen.

     */
    public String getResolution();
    /**

     * Gets the refresh rate for the screen.

     */
    public int getRefreshRate();
    /**

     * Gets the response time for the screen.

     */
    public int getResponseTime();

}
