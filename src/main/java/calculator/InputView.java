package calculator;

import java.util.Scanner;

public class InputView {
    private final String inputMessage = "좌표를 입력하세요.";
    private final Scanner in = new Scanner(System.in);

    public Line show(){
        showMessage();
        return input();
    }

    private void showMessage() {
        System.out.println(inputMessage);
    }

    private Line input(){
        return new Line(in.nextLine());
    }

}
