public class AudioPlayer extends Product implements MultimediaControl{
    String supportedAudioFormats;
    String supportedPlaylistFormats;

    AudioPlayer(String name, String manufacturer, String supportedAudioFormats, String supportedPlaylistFormats){
        super(name, manufacturer, ItemType.AUDIO);
        this.supportedPlaylistFormats = supportedPlaylistFormats;
        this.supportedAudioFormats = supportedAudioFormats;
    }

    public String toString(){
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type + "\nSupported Audio Formats: " + supportedAudioFormats + "\nSupported Playlist Formats: " + supportedPlaylistFormats;
    }

    public void play(){
        System.out.println("Playing");
    }

    public void stop(){
        System.out.println("Stopping");
    }

    public void next(){
        System.out.println("Next");
    }

    public void previous(){
        System.out.println("Previous");
    }
}
