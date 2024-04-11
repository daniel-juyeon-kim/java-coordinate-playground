package calculator;

import java.util.Scanner;

public class InputView {
    private final String INPUT_MESSAGE = "좌표를 입력하세요.";
    private final Scanner in = new Scanner(System.in);

    public Shape show(){
        showMessage();
        return input();
    }

    private void showMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    private Shape input(){
        return Shape.generate(in.nextLine());
    }

}
