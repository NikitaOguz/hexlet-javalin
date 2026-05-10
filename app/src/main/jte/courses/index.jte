@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <h2>${page.getHeader()}</h2>

    <form action="/courses" method="get">
        <input
                type="search"
                name="term"
                value="${page.getTerm()}"
                placeholder="Поиск курса"
        />
        <input type="submit" value="Search" />
    </form>

    @if(page.getCourses().isEmpty())
        <p>Ничего не найдено</p>
    @else
        @for(var course : page.getCourses())
            <div>
                <h3>${course.getName()}</h3>
                <p>${course.getDescription()}</p>
            </div>
        @endfor
    @endif
`
)