package javaTester;

import org.testng.Assert;

public class Topic_04_Text {
    public static void main(String[] args) {
        String fullName = "Tô Trinh" ;
        System.out.println(fullName);

        fullName = "Tô Trinh changed" ;
        System.out.println(fullName);

    String textItem = "\n" +
            "       Second Option\n" +
            "                 " ;
    Assert.assertEquals(textItem.trim(),"Second Option");
}
}