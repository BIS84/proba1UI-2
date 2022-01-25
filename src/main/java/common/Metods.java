package common;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Metods {

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("target/screenshots/createDepartmentTests/Tests$CreateDepartmentsTests/createDepartmentsLevels_2_5", resourceName));
    }

}
