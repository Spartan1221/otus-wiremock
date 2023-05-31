import io.restassured.response.Response;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.GetUserIdApi;

import static org.assertj.core.api.Assertions.assertThat;

public class UserGetIdTests {

    @Test
    @DisplayName("Если вызвать сервис, то в ответе вернется статус 200 и корректное тело")
    public void userGetIdTest() {
        GetUserIdApi getUserIdApi = new GetUserIdApi();
        Response response = getUserIdApi.get("34");

        assertThat(response.getStatusCode())
                .as("Ожидалось, что запрос прошел успешно")
                .isEqualTo(200);

        User actualBody = response.getBody().as(User.class);
        User expectedBody = User.builder()
                .name("Test user")
                .score(78)
                .build();

        assertThat(actualBody)
                .as("Тело ответа не соответствует ожиданиям")
                .isEqualTo(expectedBody);
    }
}
