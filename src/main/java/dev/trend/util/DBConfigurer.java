package dev.trend.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * DB 설정 파일을 읽어서 Properties 객체로 바인딩해주는 유틸 클래스
 */
public class DBConfigurer {

    /**
     * 메서드에 대한 설명 작성해보기
     *
     * @param argument - DB 설정 파일명(ex. jdbc.properties)
     * @return properties - 설정 파일 내 설정 값을 담은 Properties 객체
     */
    public static Properties readProperties(String argument) {
        String propertiesFilePath = argument;
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(propertiesFilePath)) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return properties;
    }
}

