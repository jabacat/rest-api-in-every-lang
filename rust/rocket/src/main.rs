#[macro_use] extern crate rocket;

const LANGUAGES: [&str; 6] = ["rust", "python", "java", "c++", "c#", "go", "javascript"];

#[get("/")]
fn index() -> &'static str {
    "Hello world!"
}

#[get("/langs/<lang>")]
fn langs(lang: String) -> String {
    match LANGUAGES.iter().find(|&x| x == &lang) {
        Some(_) => format!("{} is a programming language", lang),
        None => format!("{} is not a programming language", lang),
    }
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index, langs])
}
