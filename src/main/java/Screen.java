public class Screen implements ScreenSpec{

    String resolution;
    int refreshrate;
    int responsetime;

    public String getResolution(){
        return resolution;
    }

    public int getRefreshRate(){
        return refreshrate;
    }

    public int getResponseTime(){
        return responsetime;
    }

    public String toString(){
        return "Screen:" + "\nResolution: " + getResolution() + "\nRefresh rate: " + getRefreshRate() + "\nResponse time: " + getResponseTime();
    }

    Screen(String resolution, int refreshrate, int responsetime){
        this.resolution = resolution;
        this.refreshrate = refreshrate;
        this.responsetime = responsetime;
    }

}
