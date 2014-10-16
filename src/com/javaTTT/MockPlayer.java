package com.javaTTT;

/**
 * Created by robertmulholand on 10/16/14.
 */
public class MockPlayer extends Player {

    @Override
    public String getMove() {
        String verification = "Get move called";
        return verification;
    }

}
