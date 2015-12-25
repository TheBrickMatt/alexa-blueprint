package com.thebrickmatt.alexa.blueprint;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

import java.util.HashSet;
import java.util.Set;

// This is the entry point for Lamba functions
public final class BlueprintLambaEntryPoint extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<String>();
        supportedApplicationIds.add("ARN from your Alexa skill"); // TODO: update with your skill's ARN
    }

    public BlueprintLambaEntryPoint() {
        super(new BlueprintSpeechlet(), supportedApplicationIds);
    }
}
