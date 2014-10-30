package com.javaTTT;

import java.util.HashMap;

abstract class Player {

    // parameters only useful for smart ai player at this point
    abstract int getMove(HashMap<Integer, String> board, String otherPlayerMove, String thisPlayerMove);

    abstract String getMoveSignature();

}
