package thread.threadpoll;

public class Cave {
    private int water = 40;

    public int getWater() {
        return water;
    }
    public void pump() {
        if (getWater() > 0) water--;
    }
}
