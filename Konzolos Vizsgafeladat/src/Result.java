public class Result {
    private String golfTournament;
    private int playerId;
    private int round1;
    private int round2;
    private int round3;
    private int round4;
    private int totalRounds;

    public Result(String golfTournament, int playerId, int round1, int round2, int round3, int round4) {
        this.golfTournament = golfTournament;
        this.playerId = playerId;
        this.round1 = round1;
        this.round2 = round2;
        this.round3 = round3;
        this.round4 = round4;
        this.totalRounds = round1 + round2 + round3 + round4;
    }

    public String getGolfTournament() {
        return golfTournament;
    }

    public void setGolfTournament(String golfTournament) {
        this.golfTournament = golfTournament;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRound1() {
        return round1;
    }

    public void setRound1(int round1) {
        this.round1 = round1;
    }

    public int getRound2() {
        return round2;
    }

    public void setRound2(int round2) {
        this.round2 = round2;
    }

    public int getRound3() {
        return round3;
    }

    public void setRound3(int round3) {
        this.round3 = round3;
    }

    public int getRound4() {
        return round4;
    }

    public void setRound4(int round4) {
        this.round4 = round4;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(int totalRounds) {
        this.totalRounds = totalRounds;
    }
}
