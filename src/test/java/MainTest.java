
import org.junit.Test;
import org.michel.Main;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertThat;

public class MainTest {
   @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
      System.out.println( Main.transform(collection));
    }

    @Test
    public void getStringShouldOutputEvenUnevenString() {
        System.out.println( Main.getString(asList(3,44)));
        //).isEqualTo("o3,e44");
        System.out.println( Main.getString(singletonList(3)));
        //).isEqualTo("o3");
    }

}
