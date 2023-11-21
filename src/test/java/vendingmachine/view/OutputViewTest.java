package vendingmachine.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OutputViewTest {

    @Test
    void 포맷팅_기능테스트(){
        System.out.printf("%d원 %d개", 500, 1);
    }

}