package first_maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Menghui Chen
 * @version ：2018年2月2日 上午10:42:22
 * @Description:
 */
public class Sl4j {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Sl4j.class);
        logger.info("Hello World");
   }

}
