package miccab.pi4jfun.lcd;

import com.pi4j.crowpi.components.LcdDisplayComponent;
import miccab.pi4jfun.Pi4jManager;

public class Runner {
    public static void main(String[] args) {
        try (Pi4jManager pi4jManager = new Pi4jManager()) {
            LcdDisplayComponent lcd = new LcdDisplayComponent(pi4jManager.pi4j());
            lcd.initialize();

            // Write text to the lines separate
            lcd.writeLine("Hello", 1);
            lcd.writeLine("   World!", 2);

            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
