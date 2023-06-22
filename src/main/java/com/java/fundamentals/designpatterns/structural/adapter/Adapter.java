package com.java.fundamentals.designpatterns.structural.adapter;

import java.util.List;

/**
 * Adapter pattern works as a bridge between two incompatible interfaces.
 * This type of design pattern comes under structural pattern as this pattern combines the capability of two independent interfaces.
 *
 * This pattern involves a single class which is responsible to join functionalities of independent or incompatible interfaces.
 *
 * A real life example could be a case of card reader which acts as an adapter between memory card and a laptop.
 * You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.
 */
public class Adapter {

    public static void main(String[] args) {
        MediaPlayer customMediaPlayer = new MediaPlayer();
        customMediaPlayer.play(MediaTypeEnum.MP3, "file.mp3");
        customMediaPlayer.play(MediaTypeEnum.MP4, "file.mp4");
        customMediaPlayer.play(MediaTypeEnum.AVI, "file.avi");
        customMediaPlayer.play(MediaTypeEnum.VLC, "file.vlc");
    }

}

enum MediaTypeEnum {
    MP3, MP4, AVI, VLC
}

interface IMediaPlayer {
    void play(MediaTypeEnum mediaTypeEnum, String fileName);
}

interface AdvancedMediaPlayer {
    void playMp4(String fileName);
    void playAvi(String fileName);
}

class Mp3Player {
    public void play(String fileName) {
        System.out.println("Playing mp3 file. Name: " + fileName);
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        // do nothing and violated ISP - Interface Segregation Principle
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}

class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        System.out.println("Playing avi file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // do nothing and violated ISP - Interface Segregation Principle
    }
}

class MediaAdapter implements IMediaPlayer {

    @Override
    public void play(MediaTypeEnum mediaTypeEnum, String fileName) {

        switch (mediaTypeEnum) {
            case MP3:
                new Mp3Player().play(fileName);
                break;
            case MP4:
                new Mp4Player().playMp4(fileName);
                break;
            case AVI:
                new AviPlayer().playAvi(fileName);
                break;
            default:
                System.out.println("Media not supported: " + mediaTypeEnum + " | fileName: " + fileName);
        }

    }

}

class MediaPlayer extends MediaAdapter {
    MediaAdapter mediaAdapter;

    @Override
    public void play(MediaTypeEnum mediaTypeEnum, String fileName) {
        new MediaAdapter().play(mediaTypeEnum, fileName);
    }
}
