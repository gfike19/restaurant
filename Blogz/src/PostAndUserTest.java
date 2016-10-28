import java.util.Date;

import org.junit.Test;

public class PostAndUserTest {
	// instance properties go here

    private static boolean initialized = false;
    public PostAndUserTest() {
    	Date dt = new Date();

       User u = new User("jdoe", "1two3four");
       Post p = new Post("words x 3", "title", "jdoe", dt);

        if (!initialized) {
            // code that should only run once goes here
            initialized = true;
        }

    }
    
    
}
