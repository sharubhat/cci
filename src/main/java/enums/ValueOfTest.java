package enums;

import java.util.Arrays;

/**
 * Created by sharath on 6/30/16.
 */
public class ValueOfTest {
    public static enum ClientType {
        OTHER(null),
        DEFAULT("default"),
        DEFAULT_FAILOVER("default_failover");

        private final String clientClassName;

        private ClientType(String className) {
            this.clientClassName = className;
        }

        protected String getClientClassName() {
            return this.clientClassName;
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(ClientType.values()));
        System.out.println(ClientType.valueOf("OTHER"));
    }

}
