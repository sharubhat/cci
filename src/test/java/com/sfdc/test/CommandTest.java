package com.sfdc.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by sharath on 4/7/15.
 */
public class CommandTest {
    // program should throw IAE for invalid input(less than a word)
    // program should throw IAE for invalid command
    // depends should throw IAE if input has less than 3 words
    // if dependency is re-defined, throw exception(if a software is already installed and dependency changes,
    // it violates the previous definition )
    // after install, list output should contain installed software
    // install software without any dependency
    // after install, all it's dependencies must have been installed
    // should return already installed message if software is already installed
    // should ignore dependency which has been already installed
    // should install all dependencies needed to install any dependency for given software
    // remove should remove the software
    // remove should remove it's dependencies which are no longer needed
    // remove should not remove software needed by other installed software
    // remove should return still needed message if it's required by other software

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void shouldThrowIAEForEmptyInput() {
        systemInMock.provideText("\n");

        try {
            Command.main(null);
            fail("expected IllegalArgumentException for empty line");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Empty Line");
        }
    }

    @Test
    public void shouldThrowIAEForInvalidCommand() {
        systemInMock.provideText("command");

        try {
            Command.main(null);
            fail("expected IllegalArgumentException for invalid input");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Invalid input");
        }
    }

    @Test
    public void dependShouldThrowIAEForLessInputsWithThanThreeWords() {
        systemInMock.provideText("DEPEND TCPIP");

        try {
            Command.main(null);
            fail("expected IllegalArgumentException for incomplete DEPEND command");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Insufficient dependencies");
        }
    }

    @Test
    public void dependShouldThrowExceptionIfDependencyIsBeingRedefined() {
        systemInMock.provideText("DEPEND   TELNET TCPIP NETCARD \nDEPEND   TELNET TCPIP NETCARD");

        try {
            Command.main(null);
            fail("expected IllegalArgumentException trying to redefine DEPEND command");
        } catch (Exception e) {
            assertThat(e)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Failed to redefine dependencies");
        }
    }

    @Test
    public void afterInstallListShouldContainInstalledSoftware() {
        systemInMock.provideText("DEPEND TCPIP NETCARD\n" +
                "INSTALL TCPIP\n" +
                "LIST");

        Command.main(null);

        // since log.getLog() returns everything from system out,
        // TCPIP will be expected exactly twice, once installing and other from list command.
        // expecting <anything including space character> TCPIP <anything> TCPIP <anything>
        assertThat(log.getLog()).matches("(.|\\s)*(TCPIP)(.|\\s)*(TCPIP)(.|\\s)*");
    }

    @Test
    public void installSoftwareWithOutAnyDependencyShouldSucceed() {
        systemInMock.provideText("INSTALL TCPIP\n" +
                "LIST");

        Command.main(null);

        assertThat(log.getLog()).isEqualTo("\tInstalling TCPIP\n" +
                "\tTCPIP\n");
    }

    @Test
    public void installShouldHaveInstalledAllDependencies() {
        systemInMock.provideText("DEPEND   TELNET TCPIP NETCARD\n" +
                "INSTALL TELNET\nLIST");
        Command.main(null);
        assertThat(log.getLog()).contains("\tTELNET\n");
        assertThat(log.getLog()).contains("\tTCPIP\n");
        assertThat(log.getLog()).contains("\tNETCARD\n");
    }
}
