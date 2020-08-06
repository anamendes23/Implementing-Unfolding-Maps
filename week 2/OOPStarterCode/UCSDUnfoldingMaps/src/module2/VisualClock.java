package module2;

import processing.core.*;
import java.time.LocalDateTime;

public class VisualClock extends PApplet{

    private String url = "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&url=https%3A%2F%2Fimg1.coastalliving.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F4_3_horizontal_inbody_900x506%2Fpublic%2Fimage%2F2016%2F07%2Fmain%2Fla-jolla-cove-best-beaches-san-diego-gettyimages-632168041.jpg%3Fitok%3DUnhw14EW";
    private PImage backgroundImg;
    private int[] colors;

    public void setup(){
        size(500,400);
        background(0);
        backgroundImg = loadImage(url, "jpg");
        backgroundImg.resize(0,height);
        image(backgroundImg, 0,0);
        colors = new int[3];
    }

    public void draw() {
        drawSmileyFace();
        //updateColors();
        colors = sunColorSet(hour());
        drawSun();
    }

    // method that changes the color of the sun based on the hour of the day
    //the color ranges from yellow to light blue
    private void updateColors() {
        //get time stamp
        int time = LocalDateTime.now().getHour();
        //color goes from yellow(255,209,0) to grey(183,185,192);
        colors[0] = 255 - time * 3;
        colors[1] = 209- time;
        colors[2] = time * 8;
    }

    //this method also changes the color of the sun based on time, but
    //the method changes the brightness of the color to achieve a darker tone
    private int[] sunColorSet(float hour) {
        int[] rgb = new int[3];
        //scale the brightness of the yellow based on the seconds.
        //30 seconds is black. 0 seconds is bright yellow
        //float diffFrom30 = Math.abs(30 - seconds);
        float diffFrom24 = Math.abs(24 - hour);

        float ratio = diffFrom24/24;
        rgb[0] = (int)(255*ratio);
        rgb[1] = (int)(255*ratio);
        rgb[2] = 0;

        return rgb;
    }

    private void drawSun() {
        fill(colors[0],colors[1],colors[2]);
        stroke(colors[0],colors[1],colors[2]);
        ellipse((width/4)*3.3f, height/5, width/6, height/5);
    }

    private void drawSmileyFace() {
        fill(255,209,0);
        stroke(0,0,0);
        ellipse(100,100,150,150);
        fill(0,0,0);
        ellipse(80,85,30,40);
        fill(0,0,0);
        ellipse(120,85,30,40);
        noFill();
        arc(100,120, 70,70,0,PI);
    }
}
