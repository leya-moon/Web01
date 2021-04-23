/**
 * 패키지의 명명규칙
 * 보통 com(kr).회사이름.(플랫폼).프로그램이름
 * 웹사이트 주소를 반대로 기재한 모양으로 패키지 이름을 많이 부여
 * 명칭은 소문자 사용
 * 소스 파일들을 각각의 그룹으로 구분하기 위해 .으로 구분
 */
package com.moon.intelli.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class RecruitListServlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Properties jdbcProperties = new Properties();
        jdbcProperties.setProperty("user", "root");
        jdbcProperties.setProperty("password", "recruit6670");
    }
}
