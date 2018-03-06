package xyz.grafgeest.puzzlers.util;

public class ProgressBarRotating extends Thread {
    private boolean showProgress = true;
    public void run() {
        String anim= "|/-\\";
        int x = 0;
        while (showProgress) {
            System.out.print("\r Processing " + anim.charAt(x++ % anim.length()));
            try {
                Thread.sleep(100);
            }
            catch (Exception ignored) {}
        }
    }

    public void interrupt() {
        this.showProgress = false;
    }
}
