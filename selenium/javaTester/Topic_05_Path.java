package javaTester;

public class Topic_05_Path {
    public static void main(String[] arg) {
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String projectPath = System.getProperty("user.dir");
        String uploadFilePath = projectPath + "/uploadFiles/";
        String germann = "benaja-germann.jpg";
        String zheng = "haotian-zheng.jpg";
        String neverchange = "thingsneverchange-unsplash.jpg";
        String germannPath = uploadFilePath + germann;
        String zhengPath = uploadFilePath + zheng;
        String neverchangePath = uploadFilePath + neverchange;
        // '/Users/lap14811/code/Selenium_Online_31/02- selenium/selenium-java-testng/sourceDocs/uploadFiles/benaja-germann.jpg'

        System.out.println(osName);
        System.out.println(javaVersion);
        System.out.println(projectPath);
        System.out.println(uploadFilePath);
        System.out.println(germannPath);
    }
}
