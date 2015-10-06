package com.vgrinyov.TicToe;

/**
 * Created by Grinyov Vitaliy on 06.10.15.
 *
 * Класс объекты которого будут запонять ячейки игры
 */
public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public CharSequence getName() {
        return (CharSequence) name;
    }
}
