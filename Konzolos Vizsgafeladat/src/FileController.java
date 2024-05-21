import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {

    public FileController() {}

    public ArrayList<Player> readPlayers(String fileName) {
        ArrayList<Player> players = new ArrayList<>();
        try (FileReader fr = new FileReader(fileName);
             Scanner scanner = new Scanner(fr)) {

            // Skip header
            scanner.nextLine();

            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                Player player = new Player(row);
                players.add(player);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return players;
    }

    public ArrayList<Result> readResults(String fileName) {
        ArrayList<Result> results = new ArrayList<>();
        String csvSplitBy = ";";
        try (FileReader fr = new FileReader(fileName);
             Scanner scanner = new Scanner(fr)) {

            // Skip header
            scanner.nextLine();

            while (scanner.hasNext()) {
                String row = scanner.nextLine();
                String[] rowSp = row.split(csvSplitBy);
                Result result = new Result(
                        rowSp[0], 
                        Integer.parseInt(rowSp[1]), 
                        Integer.parseInt(rowSp[2]), 
                        Integer.parseInt(rowSp[3]), 
                        Integer.parseInt(rowSp[4]), 
                        Integer.parseInt(rowSp[5])
                );
                results.add(result);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }
}
