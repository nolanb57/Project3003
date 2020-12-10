public class Screen implements ScreenSpec{

    /**

     * The resolution for the monitor.

     */
    String resolution;
    /**

     * The refresh rate for the monitor.

     */
    int refreshRate;
    /**

     * The response time for the monitor.

     */
    int responseTime;

    /**

     * Getter to get the resolution.

     * @return returns the resolution of the screen.

     */
    public String getResolution(){
        return resolution;
    }

    /**

     * Getter to get the refresh rate.

     * @return returns the refresh rate of the screen.

     */
    public int getRefreshRate(){
        return refreshRate;
    }

    /**

     * Getter to get the response time.

     * @return returns the response time of the screen.

     */
    public int getResponseTime(){
        return responseTime;
    }

    /**

     * Prints screen details as a string.

     * @return Returns a string with screen details.

     */
    public String toString(){
        return "Screen:" + "\nResolution: " + getResolution() + "\nRefresh rate: " + getRefreshRate() + "\nResponse time: " + getResponseTime();
    }

    /**

     * Constructor to create a screen.

     * @param responseTime the response time of the screen.
     * @param refreshRate the refresh rate of the screen.
     * @param resolution resolution of the screen.

     */
    Screen(String resolution, int refreshRate, int responseTime){
        this.resolution = resolution;
        this.refreshRate = refreshRate;
        this.responseTime = responseTime;
    }

}
