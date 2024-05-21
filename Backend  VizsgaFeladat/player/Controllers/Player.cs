namespace GolfApi.Models
{
    public class Player
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public List<Result> Results { get; set; } = new List<Result>();
    }
}
