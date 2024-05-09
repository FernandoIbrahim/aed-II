import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Closeable {

    private FileReader fileReader;
    private BufferedReader buffer;

    CSVReader(Path path) throws FileNotFoundException {

        try {

            this.fileReader = new FileReader(path.toString());
            this.buffer = new BufferedReader(fileReader);

        } catch (FileNotFoundException erro) {

            System.out.println("Error" + erro.getMessage());

        }

    }

    public List<String[]> readFileLines() throws IOException {

        List<String[]> fileLines = new ArrayList<>();
        String line;
        String devidedLine[];

        buffer.readLine();

        while ((line = buffer.readLine()) != null) {

            devidedLine = line.split("\t");
            fileLines.add(devidedLine);

        }

        return fileLines;

    }


    @Override
    public void close() throws IOException {
        this.fileReader.close();
        this.buffer.close();
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

}
