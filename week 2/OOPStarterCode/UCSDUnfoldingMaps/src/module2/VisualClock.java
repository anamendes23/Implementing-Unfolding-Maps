package module2;

import processing.core.*;
import java.time.LocalDateTime;

public class VisualClock extends PApplet{

    private String url = "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&url=https%3A%2F%2Fimg1.coastalliving.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F4_3_horizontal_inbody_900x506%2Fpublic%2Fimage%2F2016%2F07%2Fmain%2Fla-jolla-cove-best-beaches-san-diego-gettyimages-632168041.jpg%3Fitok%3DUnhw14EW";
    private PImage backgroundImg;
    private int red;
    private int green;
    private int blue;

    public void setup(){
        size(500,400);
        backgroundImg = loadImage(url, "jpg");
        backgroundImg.resize(0,height);
    }

    public void draw() {
        background(0);
        image(backgroundImg, 0,0);
        drawSmileyFace();
        updateColors();
        drawSun();
    }

    private void updateColors() {
        //get time stamp
        int time = LocalDateTime.now().getHour();
        //color goes from yellow(255,209,0) to grey(183,185,192);
        red = 255 - time * 3;
        green = 209- time;
        blue = time * 8;
    }

    private void drawSun() {
        fill(red,green,blue);
        stroke(red,green,blue);
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
