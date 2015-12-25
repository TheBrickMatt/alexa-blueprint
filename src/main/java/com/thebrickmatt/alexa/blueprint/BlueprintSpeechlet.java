package com.thebrickmatt.alexa.blueprint;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.thebrickmatt.alexa.blueprint.model.GameState;
import com.thebrickmatt.alexa.blueprint.transform.SessionHelper;
import com.thebrickmatt.alexa.blueprint.transform.SpeechBuilder;

public class BlueprintSpeechlet implements Speechlet {

    public static final String MY_BLUEPRINT_INTENT = "BluePrintIntent";
    public static final String AMAZON_STOP_INTENT = "AMAZON.StopIntent";
    public static final String AMAZON_CANCEL_INTENT = "AMAZON.CancelIntent";
    public static final String AMAZON_HELP_INTENT = "AMAZON.HelpIntent";

    /**
     * Called when a new session is started
     */
    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {

        // initialization logic
        final SessionHelper sessionHelper = new SessionHelper(session);
        sessionHelper.setGameState(GameState.INITIALIZING);
    }

    /**
     * Called when a simple start command is issued, otherwise the onIntent is called
     */
    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session)
            throws SpeechletException {
        final SessionHelper sessionHelper = new SessionHelper(session);
        sessionHelper.setGameState(GameState.INITIALIZING);
        return SpeechBuilder.wrapAskSpeech("Welcome to the Alexa Blue Print. What can I do for you?");
    }

    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session)
            throws SpeechletException {
        final SessionHelper sessionHelper = new SessionHelper(session);

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        // NOTE: Session Attributes don't work like a servlet session.
        // Even though they take object, they are marshaled via JSON, so enum becomes string, etc.
        GameState gameState = sessionHelper.getGameState();

        if (AMAZON_HELP_INTENT.equals(intentName)) {
            return SpeechBuilder.wrapAskSpeech("Sounds like you need help.  Am I right?", "Am I right?");
        }

        if (AMAZON_STOP_INTENT.equals(intentName)) {
            return SpeechBuilder.wrapTellSpeech("Hammer Time. Good bye from blue print.");
        }

        if (AMAZON_CANCEL_INTENT.equals(intentName)) {
            return SpeechBuilder.wrapTellSpeech("Canceling. Good bye from blue print.");
        }

        if (MY_BLUEPRINT_INTENT.equals(intentName)) {
            if (gameState == GameState.INITIALIZING) {
                sessionHelper.setGameState(GameState.RUNNING);
                return SpeechBuilder.wrapAskSpeech("You gave a blue print intent, and we just initialized.  What next?", "What next?");
            } else if (gameState == GameState.RUNNING) {
                return SpeechBuilder.wrapAskSpeech("You gave a blue print intent, but we're already initialized.  What next?", "What next?");
            }
        }

        return SpeechBuilder.wrapTellSpeech("I don't know how to handle your intent, which was " + intentName);
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        // clean things up
    }
}
