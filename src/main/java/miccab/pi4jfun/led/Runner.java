package miccab.pi4jfun.led;

import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import miccab.pi4jfun.Pi4jManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
    private static final Integer PIN_LED = 16;

    public static void main(String[] args) {
        long  czasSwiecenia= Long.parseLong(args[0]);

        try (Pi4jManager pi4jManager = new Pi4jManager()) {
            pi4jManager.printInfo();

            var ledConfig = DigitalOutput.newConfigBuilder(pi4jManager.pi4j())
                    .id("led")
                    .name("LED Flasher")
                    .address(PIN_LED)
                    .shutdown(DigitalState.LOW)
                    .initial(DigitalState.LOW)
                    .provider("pigpio-digital-output");
            var led = pi4jManager.pi4j().create(ledConfig);


            led.high();
            Thread.sleep(czasSwiecenia);
            led.low();
            Thread.sleep(1_000);
            led.high();
            Thread.sleep(1_000);

        } catch (Exception e) {
            LOG.error("Unexpected error", e);
        }
    }
}
