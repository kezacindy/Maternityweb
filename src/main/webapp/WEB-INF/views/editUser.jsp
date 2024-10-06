<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        h2 {
            text-align: center;
        }
        form {
            width: 100%;
            display: flex;
            flex-direction: column;
        }
        input[type="text"],
        input[type="email"],
        input[type="date"],
        input[type="password"] {
            padding: 10px;
            margin: 10px 0;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        select {
            padding: 10px;
            margin: 10px 0;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Edit User</h2>
    <form action="update" method="post">
        <input type="hidden" name="id" value="${user.userId}" />

        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${user.name}" required />

        <label for="dob">Date of Birth</label>
        <input type="date" id="dob" name="dob" value="${user.dob}" required />

        <label for="email">Email</label>
        <input type="email" id="email" name="email" value="${user.email}" required />

        <label for="gender">Gender</label>
        <select id="gender" name="gender" required>
            <option value="Male" ${user.gender == 'Male' ? 'selected' : ''}>Male</option>
            <option value="Female" ${user.gender == 'Female' ? 'selected' : ''}>Female</option>
        </select>

        <label for="phoneNumber">Phone Number</label>
        <input type="text" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" required />

        <label for="province">Province</label>
        <input type="text" id="province" name="province" value="${user.province}" required />

        <label for="title">Title</label>
        <input type="text" id="title" name="title" value="${user.title}" required />

        <label for="district">District</label>
        <input type="text" id="district" name="district" value="${user.district}" required />

        <label for="password">Password</label>
        <input type="password" id="password" name="password" value="${user.password}" required />

        <input type="submit" value="Update User" />
    </form>
</div>
</body>
</html>
