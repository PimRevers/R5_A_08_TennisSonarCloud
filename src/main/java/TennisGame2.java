public class TennisGame2 implements TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        // Cas 1 : Égalité
        if (player1Score == player2Score) {
            if (player1Score >= 3) {
                return "Deuce";
            }
            return SCORE_NAMES[player1Score] + "-All";
        }

        // Cas 2 : Avantage ou Victoire (au moins 4 points marqués)
        if (player1Score >= 4 || player2Score >= 4) {
            int diff = player1Score - player2Score;
            if (diff == 1) {
                return "Advantage " + player1Name;
            }
            if (diff == -1) {
                return "Advantage " + player2Name;
            }
            if (diff >= 2) {
                return "Win for " + player1Name;
            }
            return "Win for " + player2Name;
        }

        // Cas 3 : Jeu normal en cours
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }

    public void SetP1Score(int number) {
        for (int i = 0; i < number; i++) {
            P1Score();
        }
    }

    public void SetP2Score(int number) {
        for (int i = 0; i < number; i++) {
            P2Score();
        }
    }

    public void P1Score() {
        player1Score++;
    }

    public void P2Score() {
        player2Score++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1Score();
        } else {
            P2Score();
        }
    }
}