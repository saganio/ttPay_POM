package Libraries;


import Utils.Log;

public class ShellCommandExecutor {

    public static final String osPlatform = System.getProperty("os.name");

    public static void executeCommand(String command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (osPlatform.startsWith("Windows")) {
                processBuilder.command("cmd.exe", "/c", command);
            } else {
                processBuilder.command("sh", "-c", command);
            }
            Process process = processBuilder.start();
            if (process.waitFor() != 0) {
                Log.info(String.format("Failed to execute [ %s ]. Failed to create capability file(s).", command));
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}