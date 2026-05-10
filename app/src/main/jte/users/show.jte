@import org.example.hexlet.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h2>Пользователь</h2>
    <p>${page.getId()}</p>
`
)