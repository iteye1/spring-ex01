Spring Example 01
================Supposing you have 2 databases to work with.
For each web request, you need to fetch data from 2 DBs and merge the results.
This is an exercise for the target.
It uses spring MVC, JdbcTemplate, Gson and returns json data.
================It runs on tomcat 6.
<Host>
....
<Context path="/r1" docBase="c:\dev\spring-ex01\target\spring-ex01-1.0" 
reloadable="false" />
</Host>

================Testing URLs:
http://localhost:8081/r1/svc/ex01/ids
http://localhost:8081/r1/svc/ex01/ids2

================Example results:
http://localhost:8081/r1/svc/ex01/ids
[{"shardId":10155,"classNameId":10021,"classPK":10154,"name":"default"}]

http://localhost:8081/r1/svc/ex01/ids2
[{"shardId":10155,"classNameId":10021,"classPK":10154,"name":"default"}
,{"shardId":10155,"classNameId":10021,"classPK":10154,"name":"default"}]

================It supports cross domain access
By setting the following in json.jsp
<%
response.addHeader("Access-Control-Allow-Origin", "*");
response.setContentType("application/json");
%>
