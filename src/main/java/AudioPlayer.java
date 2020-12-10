/**

 * Represents an Audio Player with Audio controls.

 * An Audio player is converted to a string for info.

 * @author Nolan Birmingham

 */

public class AudioPlayer extends Product implements MultimediaControl{

    /**

     * The Audio Formats that are supported.

     */
    String supportedAudioFormats;
    /**

     * The Playlist formats that are supported.

     */
    String supportedPlaylistFormats;
    /**

     * Constructor to create an Audio Player.

     * @param manufacturer this players manufacturer.
     * @param name this players name.
     * @param supportedAudioFormats The Audio Formats that are supported.
     * @param supportedPlaylistFormats The Playlist formats that are supported.

     */
    AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats){
        super(name, manufacturer, ItemType.AUDIO);
        this.supportedPlaylistFormats = supportedPlaylistFormats;
        this.supportedAudioFormats = supportedAudioFormats;
    }

    /**

     * Prints audio player details as a string.

     * @return Returns a string with audio player details.

     */
    public String toString(){
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type + "\nSupported Audio Formats: " + supportedAudioFormats + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
    }

    /**

     * "Plays" the audio player.

     */
    public void play(){
        System.out.println("Playing");
    }

    /**

     * "Stops" the audio player.

     */
    public void stop(){
        System.out.println("Stopping");
    }

    /**

     * "Plays" the next track on the audio player.

     */
    public void next(){
        System.out.println("Next");
    }

    /**

     * "Plays" the previous track on the audio player.

     */
    public void previous(){
        System.out.println("Previous");
    }
}
