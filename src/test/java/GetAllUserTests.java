import io.restassured.response.Response;
import model.UserFull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.GetAllUserApi;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllUserTests {

    @Test
    @DisplayName("Если вызвать сервис, то в ответе вернется статус 200 и корректное тело")
    public void userGetAllTest() {
        GetAllUserApi getAllUserApi = new GetAllUserApi();
        Response response = getAllUserApi.get();

        assertThat(response.getStatusCode())
                .as("Ожидалось, что запрос прошел успешно")
                .isEqualTo(200);

        UserFull actualBody = response.getBody().as(UserFull.class);
        UserFull expectedBody = UserFull.builder()
                .name("Test user")
                .cource("QA")
                .email("test@test.test")
                .age(23)
                .build();

        assertThat(actualBody)
                .as("Тело ответа не соответствует ожиданиям")
                .isEqualTo(expectedBody);
    }

}
