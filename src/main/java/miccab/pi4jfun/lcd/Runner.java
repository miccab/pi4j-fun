package miccab.pi4jfun.lcd;

import com.pi4j.io.i2c.I2C;
import com.pi4j.plugin.pigpio.provider.i2c.PiGpioI2CProvider;
import miccab.pi4jfun.Pi4jManager;

public class Runner {
    public static void main(String[] args) {
        try (Pi4jManager pi4jManager = new Pi4jManager()) {
            var i2c = I2C.newConfigBuilder(pi4jManager.pi4j())
                    .provider(PiGpioI2CProvider.ID);
            var lcd = pi4jManager.pi4j().create(i2c);

        }
    }
}
