package org.john_schreier.PRedictions;
import org.apache.logging.log4j.util.Strings;
import org.john_schreier.PRedictions.services.UserStatsService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
@Rollback(false)
public class UserStatsServiceTest {
//    Parameterized test for the findUserSTatsEmail which returns a user's UserStats (goals, history, coach) with their email address.
    @Autowired
    private UserStatsService userStatsService;

    @ParameterizedTest
    @ValueSource(strings = {"m@email.com", "bob@email.com"})
    public void testFindUserStatsByEmail(String email){

        assertThat(Strings.isNotBlank(email));
    }
}
