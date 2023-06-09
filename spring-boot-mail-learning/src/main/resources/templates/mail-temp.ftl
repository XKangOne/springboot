<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>freemarker 邮件</title>
</head>
<body>
<h1>这是一封Freemarker邮件</h1>
<table>
    <tr>
        <td>序号</td>
        <td>标题</td>
        <td>创建时间</td>
    </tr>
    <#list articles as article>
        <tr>
            <td>${article.id}</td>
            <td>${article.title}</td>
            <td>${article.createTime?string('dd.MM.yyyy HH:mm:ss')}</td>
        </tr>
    </#list>
</table>
</body>
</html>