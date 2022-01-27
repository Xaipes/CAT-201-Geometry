package com.example.geometry;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements initializable{

    @FXML
    private MediaView mediaView;

    @FXML
    private Button startButton;
    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    //@Override
    public void initialize(URL arg0, ResourceBundle arg1){
        file = new File("C:\\Users\\JYing\\IdeaProjects\\Geometry\\src\\ImgVid\\Background.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    public void playMedia(){
        mediaPlayer.play();
    }


}


//public class HelloController {
//    @FXML
//    private MediaView mediaView;
//
////    @Override
//    public void initialize(URL url, ResourceBundle rb){
//        Media media = new Media("file:///C:/Users/JYing/Downloads/CAT 201/Project/Background.mp4");
//        MediaPlayer player = new MediaPlayer(media);
//        mediaView.setMediaPlayer(player);
//        player.setVolume(0);
//        player.play();
//    }
//}