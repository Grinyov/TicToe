package com.vgrinyov.TicToe;

/**
 * Created by Grinyov Vitaliy on 06.10.15.
 *
 * В крестики-нолики выирывает тот, кто выстроет X или O в линию длиной,
 * равной длине поля по-вертикали, или по-горизонтали, или по-диагонали. создадим методы для каждого случая.
 * Для этого хорошо подойдет паттерн Chain of Responsobility.
 */
public interface WinnerCheckerInterface {
    public Player checkWinner();
}
