package me.whiteship.designpatterns._03_behavioral_patterns._18_memento._03_java;

import me.whiteship.designpatterns._03_behavioral_patterns._18_memento._01_before.Game;

import java.io.*;

public class MementoInJava {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Serializable
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        // TODO 직렬화
        try(FileOutputStream fileOut = new FileOutputStream("GameSave.hex");
            //여기서 아무 파일 형식이든 상관 없음, 그냥 hex가 우리가 볼때 편해서 여기선 이렇게 한것임
        ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(game);
        }

        game.setBlueTeamScore(25);
        game.setRedTeamScore(15);

        // TODO 역직렬화
        try(FileInputStream fileIn = new FileInputStream("GameSave.hex");
            ObjectInputStream in = new ObjectInputStream(fileIn))
        {
            game = (Game) in.readObject();
            System.out.println(game.getBlueTeamScore());
            System.out.println(game.getRedTeamScore());
        }
    }
}
