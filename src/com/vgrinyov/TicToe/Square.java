package com.vgrinyov.TicToe;

/**
 * Created by Grinyov Vitaliy on 06.10.15.
 *
 * Класс отвечает за ячейки в игре
 */
public class Square {


        private Player player = null;

        public void fill(Player player) {
            this.player = player;
        }

        public boolean isFilled() {
            if (player != null) {
                return true;
            }
            return false;
        }

        public Player getPlayer() {
            return player;
        }
    }

