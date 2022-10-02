package hexlet.code;

import picocli.CommandLine.Command;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;


@Command(name = "gendiff", version = "gendiff 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {
    @Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format \"stylish\" or \"plain\" or \"json\" "
            + "[default: ${DEFAULT-VALUE}]")
    private String formatName = "stylish";
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filePath1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filePath2;
    @Override
    public final String call() throws Exception {
        return Differ.generate(filePath1, filePath2, formatName);
    }

    public static void main(String[] args) {
        try {
            int exitCode = new CommandLine(new App()).execute(args);
            System.exit(exitCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
