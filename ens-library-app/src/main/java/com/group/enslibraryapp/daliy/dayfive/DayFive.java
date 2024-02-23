package com.group.enslibraryapp.daliy.dayfive;

public class DayFive {
    public static void main(String[] args) throws Exception {
        DiceAction diceAction = new DiceAction();

        //1.주사위 시행 횟수 입력
        DiceAction dice = diceAction.inputDiceSpinningCount();

        //2. 주사위 배열 셋팅
        diceAction.initDice(dice.diceEyesCount);

        //3.주사위를 굴려 주사위 수 카운트
        diceAction.spinningDice(dice);

        //3. 누적된 주사위 눈 카운트 출력
        diceAction.printDiceEyesPrint(dice);
    }
}
