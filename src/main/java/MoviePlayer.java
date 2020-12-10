/**

 * Represents an Movie Player with Movie controls.

 * A Movie player is converted to a string for info.

 * @author Nolan Birmingham

 */
class MoviePlayer extends Product implements MultimediaControl{
    /**

     * The screen variable.

     */
    Screen screen;
    /**

     * The Monitor type variable.

     */
    MonitorType monitorType;

    /**

     * Constructor to create an Movie Player.

     * @param manufacturer this players manufacturer.
     * @param name this players name.
     * @param screen The type of screen for the player.
     * @param monitorType The type of monitor in the player.

     */
    public MoviePlayer(String name, String manufacturer, Screen screen,  MonitorType monitorType){
        super(name, manufacturer, ItemType.VISUAL);

        this.screen = screen;

        this.manufacturer = manufacturer;
        this.monitorType = monitorType;


    }

    /**

     * "Plays" the movie player.

     */
    public void play(){
        System.out.println("Playing movie");
    }

    /**

     * "Stops" the movie player.

     */
    public void stop(){
        System.out.println("Stopping movie");
    }

    /**

     * "Plays" the next in the movie player.

     */
    public void next(){
        System.out.println("Next movie");
    }

    /**

     * "Plays" the previous in the movie player.

     */
    public void previous(){
        System.out.println("Previous movie");
    }

    /**

     * Prints movie player details as a string.

     * @return Returns a string with movie player details.

     */
    public String toString(){
        return super.toString() + "\n" + screen.toString() + "\nMonitor Type: " + monitorType;
    }

}
