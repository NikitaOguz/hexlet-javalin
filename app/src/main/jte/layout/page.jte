@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
<header>
    <h1>Мой сайт курсов</h1>
    <nav>
        <a href="/">Главная</a>
        <a href="/courses">Courses</a>
    </nav>
    <hr>
</header>

${content}

<footer>
    <hr>
    <a href="https://github.com/NikitaOguz">GitHub</a>
</footer>
</body>
</html>