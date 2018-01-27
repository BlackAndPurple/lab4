<%--
  Created by IntelliJ IDEA.
  User: tatja
  Date: 08.01.2018
  Time: 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Course project</title>
  </head>
  <body>
    <h3>POSSIBLE OPTIONS:</h3>
    <ul><a href="get_data/people">See all the people in the database</a> </ul>
    <ul><a href="input_person_id">Determine a type of person account by ID</a> </ul>
    <ul><a href="get_data/parents">See all the parents in the database</a> </ul>
    <ul><a href="input_parent_id">Find all children by parent's ID</a> </ul>
    <ul><a href="input_group_name">Find all children by group name</a> </ul>

  <table cellpadding="10px">
    <tr>
        <td>People</td>
        <td><a href="get_data/people">show</a> | <a href="add_person">add</a> | update | delete</td>
    </tr>
    <tr>
        <td>Parents</td>
        <td><a href="get_data/parents">show</a> | <a href="add_parent">add</a> | update | delete</td>
    </tr>
      <tr>
          <td>Parents' contacts</td>
          <td><a href="get_data/contacts">show</a> | <a href="add_contacts">add</a> | update | delete</td>
      </tr>
      <tr>
          <td>Kids</td>
          <td><a href="get_data/kids">show</a> | <a href="add_kid">add</a> | update | delete</td>
      </tr>
      <tr>
          <td>Kid accounts</td>
          <td><a href="get_data/kid_accounts">show</a> | add | update | delete</td>
      </tr>
      <tr>
          <td>Medinfo</td>
          <td><a href="get_data/medinfo">show</a> | add | update | delete</td>
      </tr>
      <tr>
          <td>Groups</td>
          <td><a href="get_data/groups">show</a> | add | update | delete</td>
      </tr>
      <tr>
          <td>Staff</td>
          <td><a href="get_data/staff">show</a> | add | update | delete</td>
      </tr>
      <tr>
          <td>Staff - group connection</td>
          <td><a href="get_data/staff_group">show</a> | add | update | delete</td>
      </tr>
  </table>
  </body>
</html>
