using GolfApi.Models;
using Microsoft.EntityFrameworkCore;
namespace player;
public class DataService: DbContext {
    public DataService(DbContextOptions<DataService> options)
        :base(options) {}
 
    public DbSet<Player> Players {get; set;} = null!;
}