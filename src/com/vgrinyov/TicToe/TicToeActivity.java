package com.vgrinyov.TicToe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

/**
 * Created by Grinyov Vitaliy on 06.10.15.
 */
public class TicToeActivity extends Activity {

    private TableLayout layout; // это свойство класса TicToe

    private Button[][] buttons = new Button[3][3];

    private Game game;

    public TicToeActivity() {  // Инициализация Game в конструкторе
        game = new Game();
        game.start(); // будет реализован позже
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        layout = (TableLayout) findViewById(R.id.main_l);
        buildGameField();
    }

        //(....)
        private void buildGameField() {
            Square[][] field = game.getField();
            for (int i = 0, lenI = field.length; i < lenI; i++ ) {
                TableRow row = new TableRow(this); // создание строки таблицы
                for (int j = 0, lenJ = field[i].length; j < lenJ; j++) {
                    Button button = new Button(this);
                    buttons[i][j] = button;
                    class Listener implements View.OnClickListener {
                        private int x = 0;
                        private int y = 0;

                        public Listener(int x, int y) {
                            this.x = x;
                            this.y = y;
                        }

                        public void onClick(View view) {
                            Button button = (Button) view;
                            Game g = game;
                            Player player = g.getCurrentActivePlayer();
                            if (g.makeTurn(x, y)) {
                                button.setText(player.getName());
                            }
                            Player winner = g.checkWinner();
                            if (winner != null) {
                                gameOver(winner);
                            }
                            if (g.isFieldFilled()) {  // в случае, если поле заполнено
                                gameOver();
                            }
                        }
                    }
                    button.setOnClickListener(new Listener (i, j) ); // установка слушателя, реагирующего на клик по кнопке

                    row.addView(button, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT)); // добавление кнопки в строку таблицы
                    button.setWidth(107);
                    button.setHeight(107);
                }
                layout.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT)); // добавление строки в таблицу
            }
        }
    }



