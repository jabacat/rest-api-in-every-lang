from fastapi import FastAPI
from random import randint, choice

"""Made with FastAPI library

Use command to run:
$ uvicorn main:app --reload
"""


class Maybe:
    def value(self):
        return bool(randint(0, 1))


app = FastAPI()

LANGS = [
    {
        "name": "Python",
        "is_good": True,
    },
    {
        "name": "Rust",
        "is_good": Maybe().value(),
    },
    {
        "name": "Go",
        "is_good": Maybe().value(),
    },
    {
        "name": "C",
        "is_good": Maybe().value(),
    },
]


@app.get("/")
def read_root():
    return {"Hello": "Team JABACAT"}


@app.get("/lang/")
def read_lang():
    return choice(LANGS)
