package com.thebrickmatt.alexa.blueprint;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

// This is the entry point if you are deploying as a war, such as in elastic beanstalk
public class BlueprintServletEntryPoint extends SpeechletServlet {

    public BlueprintServletEntryPoint() {
        this.setSpeechlet(new BlueprintSpeechlet());
    }

}
