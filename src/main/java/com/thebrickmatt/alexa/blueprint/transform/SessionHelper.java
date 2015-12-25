package com.thebrickmatt.alexa.blueprint.transform;

import com.amazon.speech.speechlet.Session;
import com.thebrickmatt.alexa.blueprint.model.GameState;

public class SessionHelper {

    private Session session;

    public SessionHelper (Session session) {
        this.session = session;
    }

    private static final String GAME_STATE = "GameState";

    public Session getSession() {
        return this.session;
    }

    public GameState getGameState() {
        String gameStateValue = (String)session.getAttribute(GAME_STATE);
        GameState gameState = GameState.valueOf(gameStateValue);
        return gameState;
    }

    public void setGameState(GameState gameState) {
        if (gameState == null) {
            session.removeAttribute(GAME_STATE);
        } else {
            session.setAttribute(GAME_STATE, gameState.name());
        }
    }
}
