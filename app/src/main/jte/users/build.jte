@import org.example.hexlet.dto.users.BuildUserPage
@param BuildUserPage page
<html>
<head>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
        }

        input {
            width: 100%;
            margin-top: 5px;
            margin-bottom: 15px;
            padding: 8px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            cursor: pointer;
        }
    </style>
</head>
<body>
@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/users" method="post">
    <div>
        <label>
            Имя
            <input type="text" name="name" value="${page.getName()}" />
        </label>
    </div>
    <div>
        <label>
            Email
            <input type="email" required name="email" value="${page.getEmail()}" />
        </label>
    </div>
    <div>
        <label>
            Пароль
            <input type="password" required name="password" />
        </label>
    </div>
    <div>
        <label>
            Подтверждение пароля
            <input type="password" required name="passwordConfirmation" />
        </label>
    </div>
    <input type="submit" value="Зарегистрировать" />
</form>
</body>
</html>