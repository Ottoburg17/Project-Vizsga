namespace GolfApi.Models
{
    public class Result
    {
        public int Id { get; set; }
        public string GolfTournament { get; set; }
        public int PlayerId { get; set; }
        public Player Player { get; set; }
        public int Round1 { get; set; }
        public int Round2 { get; set; }
        public int Round3 { get; set; }
        public int Round4 { get; set; }
        public int TotalRounds => Round1 + Round2 + Round3 + Round4;
    }
}
