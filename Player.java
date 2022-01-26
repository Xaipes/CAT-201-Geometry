//Include the file in the package
package com.geometry;

//Create a class for the player
public class Player 
{

    //Create variables to store player information
    String player_name;
    int player_score = 0;
    int player_current_level = 1;
    boolean player_is_correct;

    //Create accessor functions
    public String get_player_name(){
        return this.player_name;
    }
    public int get_player_score(){
        return this.player_score;
    }
    public int get_player_current_level(){
        return player_current_level;
    }
    public boolean get_player_is_correct(){
        return this.player_is_correct;
    }


    //Create mutator functions
    public void set_player_name(String input_name)
    {
        this.player_name = input_name;
    }

    public void set_player_score()
    {
        if (this.player_is_correct == true)
        {
            player_score = player_score + 100;
        }
        else
        {
            player_score = player_score - 50;
        }
    }

    public void set_player_current_level()
    {
        this.player_current_level = this.player_current_level + 1;
    }
    
    public void set_player_is_correct(boolean right_wrong)
    {
        this.player_is_correct = right_wrong;
    }
}