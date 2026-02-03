<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    session.invalidate(); // ล้างข้อมูลทุกอย่างที่เก็บไว้ใน Session
    response.sendRedirect("login.jsp"); // ส่งผู้ใช้กลับไปหน้า Login
%>