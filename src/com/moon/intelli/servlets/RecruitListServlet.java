/**
 * 패키지의 명명규칙
 * 보통 com(kr).회사이름.(플랫폼).프로그램이름
 * 웹사이트 주소를 반대로 기재한 모양으로 패키지 이름을 많이 부여
 * 명칭은 소문자 사용
 * 소스 파일들을 각각의 그룹으로 구분하기 위해 .으로 구분
 */
package com.moon.intelli.servlets;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class RecruitListServlet extends GenericServlet {

    @Override
    /* GenericServlet을 상속받고 service()를 override */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        String driver = "org.mariadb.jdbc.Driver";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Properties jdbcProperties = new Properties();
        jdbcProperties.setProperty("user", "root");
        jdbcProperties.setProperty("password", "recruit6670");

        /**
         * 참고 사이트
         * https://atoz-develop.tistory.com/entry/IntelliJ-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EC%98%88%EC%A0%9CJAVA-MySQL-1-%ED%9A%8C%EC%9B%90-%EB%AA%A9%EB%A1%9D-%EC%A1%B0%ED%9A%8C
         * https://thisisspear.tistory.com/4
         */
        try {
            /* JDBC 드라이버 로딩 */
            DriverManager.registerDriver(new org.mariadb.jdbc.Driver());

            conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/recruit", jdbcProperties);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT user_num, user_id, user_pw, user_name"
                    + " FROM user_info"
                    + " ORDER BY user_num"
            );

        } catch (SQLException e) {
            /*
            * SQL 예외 발생 시 ServletException 인스턴스에 담고 
            * 서블릿 컨테이너 (톰캣)에게 throw 하도록 함
            */ 
            throw new ServletException(e);
        } finally {
            
        }


    }
}
