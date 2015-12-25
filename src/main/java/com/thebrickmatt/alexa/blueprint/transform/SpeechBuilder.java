package com.thebrickmatt.alexa.blueprint.transform;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SsmlOutputSpeech;

public class SpeechBuilder {

    public static final String SPEAK_SUFFIX = "</speak>";
    public static final String SPEAK_PREFIX = "<speak>";

    public static SpeechletResponse wrapTellSpeech(String tellText) {
        SsmlOutputSpeech questionSpeech = new SsmlOutputSpeech();
        questionSpeech.setSsml(SPEAK_PREFIX + tellText + SPEAK_SUFFIX);

        return SpeechletResponse.newTellResponse(questionSpeech);
    }

    public static SpeechletResponse wrapAskSpeech(String questionText) {
        return wrapAskSpeech(questionText, questionText);
    }

    public static SpeechletResponse wrapAskSpeech(String questionText, String repromptText) {
        SsmlOutputSpeech questionSpeech = new SsmlOutputSpeech();
        questionSpeech.setSsml(SPEAK_PREFIX + questionText + SPEAK_SUFFIX);

        // Create reprompt
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(questionSpeech);

        return SpeechletResponse.newAskResponse(questionSpeech, reprompt);
    }

}
