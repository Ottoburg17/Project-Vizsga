using Microsoft.EntityFrameworkCore;
using GolfApi.Models;

namespace GolfApi.Data
{
    public class GolfContext : DbContext
    {
        public GolfContext(DbContextOptions<GolfContext> options) : base(options) { }

        public DbSet<Player> Players { get; set; }
        public DbSet<Result> Results { get; set; }
    }
}
      