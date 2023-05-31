import io.restassured.response.Response;
import model.Cource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.GetCourseAllApi;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CourceGetAllTests {

    @Test
    @DisplayName("Если вызвать сервис, то в ответе вернется статус 200 и корректное тело")
    public void courceGetAllTest() {
        GetCourseAllApi getCourseAllApi = new GetCourseAllApi();
        Response response = getCourseAllApi.get();

        assertThat(response.getStatusCode())
                .as("Ожидалось, что запрос прошел успешно")
                .isEqualTo(200);

        List<Cource> actualBody = List.of(response.getBody().as(Cource[].class));
        List<Cource> expectedBody = List.of(
                Cource.builder()
                        .name("QA java")
                        .price(15000)
                        .build(),
                Cource.builder()
                        .name("Java")
                        .price(12000)
                        .build()
        );

        assertThat(actualBody)
                .as("Тело ответа не соответствует ожиданиям")
                .isEqualTo(expectedBody);
    }
}
