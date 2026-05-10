@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Hexlet Javalin App</title>
</head>
<body>
<header>
    <h1>Hexlet Javalin App</h1>
    <nav>
        <a href="/">Главная</a>
        <a href="/courses">Курсы</a>
    </nav>
    <hr>
</header>

<main>
    ${content}
</main>

<footer>
    <hr>
    <a href="https://github.com/NikitaOguz">My GitHub</a>
</footer>
</body>
</html>