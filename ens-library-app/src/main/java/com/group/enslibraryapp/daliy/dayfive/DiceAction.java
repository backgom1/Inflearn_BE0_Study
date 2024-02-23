package com.group.enslibraryapp.daliy.dayfive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceAction {

    private Dice dice;
    int diceSpinCount;
    int diceEyesCount;


    public DiceAction() {
    }

    public DiceAction(int diceSpinCount, int diceEyesCount) {
        this.diceSpinCount = diceSpinCount;
        this.diceEyesCount = diceEyesCount;
    }

    /**
     * 주사위 눈을 초기화 메서드
     * @param diceEyesCount
     */
    public void initDice(int diceEyesCount) {
        dice = new Dice(diceEyesCount);
    }

    /**
     * 주사위 횟수를 구하는 메서드
     *
     * @return 주사위 횟수 및 주사위 눈에 대한 반환값
     */
    public DiceAction inputDiceSpinningCount() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("주사위를 몇번 던질까요? : ");
        int diceSpinCount = Integer.parseInt(bf.readLine());

        System.out.print("주사위 눈을 몇개로 설정 할까요? : ");
        int diceEyesCount = Integer.parseInt(bf.readLine());

        return new DiceAction(diceSpinCount, diceEyesCount);
    }


    /**
     * 주사위 눈 카운트 메서드
     *
     * @param diceAction 주사위를 던질 횟수와 주사위 눈의 수를 가지는 객체
     */
    public void spinningDice(DiceAction diceAction) {
        for (int i = 0; i < diceAction.diceSpinCount; i++) {
            int diceIndex = (int) ((Math.random() * diceAction.diceEyesCount));
            this.dice.diceEyes[diceIndex]++;
        }
    }

    /**
     * 주사위가 나온 합산에 대한 출력을 하는 메서드 입니다.
     */
    public void printDiceEyesPrint(DiceAction diceAction) {
        for (int i = 0; i < diceAction.diceEyesCount; i++) {
            System.out.printf("%d이 %d번 나왔습니다.\n", i + 1, this.dice.diceEyes[i]);
        }
    }
}
