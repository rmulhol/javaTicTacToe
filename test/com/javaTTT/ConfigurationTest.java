package com.javaTTT;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {

    // No Tests for factory methods

    MockDisplay mockDisplay = new MockDisplay();
    Configuration testConfiguration = new Configuration(mockDisplay);

    // test chooseGameSetup()

    @Test
    public void testModifiesSettingsIfUserSaysYes() {
        boolean modifySettings = testConfiguration.userWantsToModifyGameSettings("yes");
        assertTrue(modifySettings);
    }

    @Test
    public void testDoesNotModifySettingsIfUserSaysNo() {
        boolean modifySettings = testConfiguration.userWantsToModifyGameSettings("no");
        assertFalse(modifySettings);
    }

    // test createCustomGame()

    // test createDefaultGame()

    // test createBoard()

    // test createPlayer()

    @Test
    public void testGetPlayerIdentityCallsDisplay() {
        testConfiguration.getPlayerIdentity(1);
        boolean displayCalled = mockDisplay.verifyGetValidIntegerCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testGetPlayerMoveSignatureCallsDisplay() {
        testConfiguration.getPlayerMoveSignature(1);
        boolean displayCalled = mockDisplay.verifyGetInputCalled();
        assertTrue(displayCalled);
    }

    // test assignPlayer()

    @Test
    public void testIntroduceGameCallsDisplay() {
        testConfiguration.introduceGame();
        boolean displayCalled = mockDisplay.verifyIntroduceGameCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testOfferCustomSettingsCallsDisplay() {
        testConfiguration.offerCustomGameSettings();
        boolean displayCalled = mockDisplay.verifyOfferCustomSettingsCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testGetInputCallsDisplay() {
        testConfiguration.getInput();
        boolean displayCalled = mockDisplay.verifyGetInputCalled();
        assertTrue(displayCalled);
    }

    @Test
    public void testDisplayInputErrorCallsDisplay() {
        testConfiguration.displayInputError();
        boolean displayCalled = mockDisplay.verifyAnnounceInputErrorCalled();
        assertTrue(displayCalled);
    }

}